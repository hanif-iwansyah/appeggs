package com.hindustries.service.domain.penjualan;

import com.hindustries.dto.request.domain.penjualan.PembayaranRequest;
import com.hindustries.dto.response.domain.penjualan.OutstandingPembayaranResponse;
import com.hindustries.entity.domain.penjualan.Pembayaran;
import com.hindustries.entity.domain.penjualan.PesananPenjualan;
import com.hindustries.mapper.domain.penjualan.PembayaranMapper;
import com.hindustries.repository.domain.penjualan.PembayaranRepository;
import com.hindustries.repository.domain.penjualan.PesananPenjualanRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PembayaranService {

    private final PembayaranRepository repository;
    private final PesananPenjualanRepository pesananPenjualanRepository;
    private final PembayaranMapper mapper;

    public PembayaranService(PembayaranRepository repository, PesananPenjualanRepository pesananPenjualanRepository, PembayaranMapper mapper) {
        this.repository = repository;
        this.pesananPenjualanRepository = pesananPenjualanRepository;
        this.mapper = mapper;
    }

    @Transactional
    public Pembayaran create(PembayaranRequest request) {
        PesananPenjualan pesananPenjualan = pesananPenjualanRepository.findById(request.getPesananPenjualanId())
                .orElseThrow(() -> new IllegalArgumentException("Pesanan tidak ditemukan"));

        BigDecimal sudahDibayar = repository.sumByPesananId(request.getPesananPenjualanId());
        BigDecimal totalSetelah = sudahDibayar.add(request.getJumlahPembayaran());

        if (totalSetelah.compareTo(pesananPenjualan.getTotalHarga()) > 0) {
            throw new IllegalArgumentException("Total pembelian melebihi total pesanan: " + pesananPenjualan.getTotalHarga());
        }

        Pembayaran pembayaran = new Pembayaran();
        pembayaran.setPesananPenjualan(pesananPenjualan);
        pembayaran.setJumlahPembayaran(request.getJumlahPembayaran());
        return repository.save(pembayaran);
    }

    @Transactional(readOnly = true)
    public List<OutstandingPembayaranResponse> getOutstanding(Long pelangganId) {
        List<PesananPenjualan> unpaidOrders = repository.findUnpaidByPelangganId(pelangganId);

        return unpaidOrders.stream().map(pesanan -> {
            BigDecimal totalDibayar = repository.sumByPesananId(pesanan.getId());
            BigDecimal sisaTagihan = pesanan.getTotalHarga().subtract(totalDibayar);
            return new OutstandingPembayaranResponse(
                    pesanan.getId(),
                    pesanan.getPelanggan().getNamaPelanggan(),
                    pesanan.getTanggalPesanan(),
                    pesanan.getTotalHarga(),
                    totalDibayar,
                    sisaTagihan
            );
        }).collect(Collectors.toList());
    }

}
