package com.hindustries.service.domain.penjualan;

import com.hindustries.dto.request.domain.penjualan.PenjualanTelurRequest;
import com.hindustries.dto.response.domain.penjualan.PenjualanTelurResponse;
import com.hindustries.entity.domain.master.Pelanggan;
import com.hindustries.entity.domain.operasional.inventory.StokTelur;
import com.hindustries.entity.domain.penjualan.PenjualanTelur;
import com.hindustries.entity.domain.penjualan.PenjualanTelurDetail;
import com.hindustries.entity.domain.penjualan.PesananPenjualan;
import com.hindustries.entity.domain.penjualan.StatusPesananPenjualan;
import com.hindustries.mapper.domain.penjualan.PenjualanTelurMapper;
import com.hindustries.repository.domain.master.PelangganRepository;
import com.hindustries.repository.domain.operasional.inventory.StokTelurRepository;
import com.hindustries.repository.domain.penjualan.PenjualanTelurDetailRepository;
import com.hindustries.repository.domain.penjualan.PenjualanTelurRepository;
import com.hindustries.repository.domain.penjualan.PesananPenjualanRepository;
import com.hindustries.util.Constant;
import com.hindustries.util.InsufficientStockException;
import com.hindustries.util.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Service
public class PenjualanTelurService {

    private final PenjualanTelurRepository repository;
    private final PelangganRepository pelangganRepository;
    private final PesananPenjualanRepository pesananPenjualanRepository;
    private final PenjualanTelurDetailRepository penjualanTelurDetailRepository;
    private final StokTelurRepository stokTelurRepository;
    private final PenjualanTelurMapper mapper;

    public PenjualanTelurService(PenjualanTelurRepository repository, PelangganRepository pelangganRepository, PesananPenjualanRepository pesananPenjualanRepository, PenjualanTelurDetailRepository penjualanTelurDetailRepository, StokTelurRepository stokTelurRepository, PenjualanTelurMapper mapper) {
        this.repository = repository;
        this.pelangganRepository = pelangganRepository;
        this.pesananPenjualanRepository = pesananPenjualanRepository;
        this.penjualanTelurDetailRepository = penjualanTelurDetailRepository;
        this.stokTelurRepository = stokTelurRepository;
        this.mapper = mapper;
    }

    @Transactional
    public PenjualanTelurResponse create(PenjualanTelurRequest request) {
        Pelanggan pelanggan = pelangganRepository.findById(request.getPelangganId())
                .orElseThrow(() -> new ResourceNotFoundException(Constant.PELANGGAN, request.getPelangganId()));
        PesananPenjualan pesanan = pesananPenjualanRepository.findById(request.getPesananPenjualanId())
                .orElseThrow(() -> new ResourceNotFoundException(Constant.PESANAN_PENJUALAN, request.getPesananPenjualanId()));

        if (pesanan.getStatusPesanan() != StatusPesananPenjualan.DIKONFIRMASI
                && pesanan.getStatusPesanan() !=  StatusPesananPenjualan.DALAM_PROSES) {
            throw new IllegalStateException(Constant.ONLY_ORDER_CONFIRM_OR_ONPROCESS);
        }

        PenjualanTelur entity = mapper.toEntity(request);
        entity.setPelanggan(pelanggan);
        entity.setPesananPenjualan(pesanan);
        PenjualanTelur saved = repository.save(entity);

        // Deduct StockTelur per Detail
        List<PenjualanTelurDetail> details = penjualanTelurDetailRepository.findByPenjualanTelur_Id(saved.getId());
        for (PenjualanTelurDetail detail : details) {
            StokTelur stok =
                    stokTelurRepository.findByGradeTelurAndGudang_Id(detail.getGradeTelur(), request.getGudangId())
                    .orElseThrow(() -> new InsufficientStockException(Constant.TELUR_GRADE + Constant.ZERO_STOCK_IN_WAREHOUSE));
            if (stok.getJumlah() < detail.getJumlah()) {
                throw new InsufficientStockException(Constant.TELUR_GRADE + detail.getGradeTelur(),
                        BigDecimal.valueOf(detail.getJumlah()),
                        BigDecimal.valueOf(stok.getJumlah()));
            }
            stok.setJumlah(stok.getJumlah() - detail.getJumlah());
            stokTelurRepository.save(stok);
        }
        return mapper.toResponse(saved);
    }

}
