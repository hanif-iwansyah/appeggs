package com.hindustries.service.domain.operasional.inventory;

import com.hindustries.dto.request.domain.operasional.inventory.InventarisRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class InventarisService {
    private final List<InventarisStrategy> strategies;

    public InventarisService(List<InventarisStrategy> strategies) {
        this.strategies = strategies;
    }

    public void kelolaBarangMasuk(InventarisRequest request) {
        InventarisStrategy strategy = cariStrategy(request.getKategori());
        strategy.prosesMasuk(request.getTargetId(), request.getJumlah(), request.getKeterangan());

    }

    public void kelolaBarangKeluar(InventarisRequest request) {
        InventarisStrategy strategy = cariStrategy(request.getKategori());
        strategy.prosesKeluar(request.getTargetId(), request.getJumlah(), request.getKeterangan());
    }

    private InventarisStrategy cariStrategy(String kategori) {
        return strategies.stream()
                .filter(s -> s.isSupported(kategori))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Kategori inventaris '"+ kategori + "' tidak dikenali"));

    }

}
