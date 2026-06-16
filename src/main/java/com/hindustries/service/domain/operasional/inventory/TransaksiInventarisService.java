package com.hindustries.service.domain.operasional.inventory;

import com.hindustries.dto.response.domain.operasional.inventory.TransaksiInventarisDetailResponse;
import com.hindustries.entity.domain.operasional.inventory.BarangInventaris;
import com.hindustries.entity.domain.operasional.inventory.JenisTransaksiInventaris;
import com.hindustries.entity.domain.operasional.inventory.TransaksiInventaris;
import com.hindustries.mapper.domain.operasional.inventory.TransaksiInventarisMapper;
import com.hindustries.repository.domain.operasional.inventory.BarangInventarisRepository;
import com.hindustries.repository.domain.operasional.inventory.TransaksiInventarisRepository;
import com.hindustries.util.Constant;
import com.hindustries.util.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransaksiInventarisService {

    private final BarangInventarisRepository barangInventarisRepository;
    private final TransaksiInventarisRepository repository;

    public TransaksiInventarisService(BarangInventarisRepository barangInventarisRepository, TransaksiInventarisRepository repository, TransaksiInventarisMapper mapper) {
        this.barangInventarisRepository = barangInventarisRepository;
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<TransaksiInventarisDetailResponse> getRiwayat(Long barangId) {
        BarangInventaris barang = barangInventarisRepository.findById(barangId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        Constant.BARANG_INVENTARIS, barangId));
        List<TransaksiInventaris> transInvList = repository.findByBarangInventaris_IdOrderByTanggalTransaksiAsc(barangId);

        int balance = barang.getStokAwal();
        List<TransaksiInventarisDetailResponse> result = new ArrayList<>();

        for (TransaksiInventaris transInv : transInvList) {
            if (transInv.getJenisTransaksi() == JenisTransaksiInventaris.MASUK) {
                balance += transInv.getJumlah();
            } else {
                balance -= transInv.getJumlah();
            }
            TransaksiInventarisDetailResponse response = new TransaksiInventarisDetailResponse();
            response.setId(transInv.getId());
            response.setJenisTransaksi(transInv.getJenisTransaksi().name());
            response.setJumlah(transInv.getJumlah());
            response.setTanggalTransaksi(transInv.getTanggalTransaksi());
            response.setKeterangan(transInv.getKeterangan());
            response.setRunningBalance(balance);
            result.add(response);
        }
        return result;
    }

}
