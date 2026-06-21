package com.hindustries.service.domain.operasional.inventory;

import com.hindustries.entity.domain.operasional.inventory.StokTelur;
import com.hindustries.repository.domain.operasional.inventory.StokTelurRepository;
import com.hindustries.util.BadRequestException;
import com.hindustries.util.Constant;
import com.hindustries.util.ResourceNotFoundException;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class StokTelurService implements InventarisStrategy {

    private final StokTelurRepository repository;

    public StokTelurService(StokTelurRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean isSupported(String kategori) {
        return Constant.TELUR.equalsIgnoreCase(kategori);
    }

    @Override
    public void prosesMasuk(Long targetId, BigDecimal jumlah, String keterangan) {
        StokTelur telur = repository.findById(targetId)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.TELUR, targetId));
        telur.setJumlah(telur.getJumlah() + jumlah.intValue());
        repository.save(telur);
    }

    @Override
    public void prosesKeluar(Long targetId, BigDecimal jumlah, String keterangan) {
        StokTelur telur = repository.findById(targetId)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.TELUR, targetId));
        if (telur.getJumlah() < jumlah.intValue()) {
            throw new BadRequestException(Constant.STOCK_NOT_ENOUGH_PATTERN, Constant.TELUR);
        }
        telur.setJumlah(telur.getJumlah() - jumlah.intValue());
        repository.save(telur);
    }
}
