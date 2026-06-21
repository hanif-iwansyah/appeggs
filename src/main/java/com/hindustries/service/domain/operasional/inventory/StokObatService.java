package com.hindustries.service.domain.operasional.inventory;

import com.hindustries.entity.domain.operasional.inventory.StokObat;
import com.hindustries.mapper.domain.operasional.inventory.StokObatMapper;
import com.hindustries.repository.domain.operasional.inventory.StokObatRepository;
import com.hindustries.util.BadRequestException;
import com.hindustries.util.Constant;
import com.hindustries.util.ResourceNotFoundException;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;

@Component
public class StokObatService implements InventarisStrategy {

    private final StokObatRepository repository;

    public StokObatService(StokObatRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean isSupported(String kategori) {
        return Constant.OBAT.equalsIgnoreCase(kategori);

    }

    @Override
    public void prosesMasuk(Long targetId, BigDecimal jumlah, String keterangan) {
        StokObat obat = repository.findById(targetId)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.STOK_OBAT, targetId));
        obat.setJumlah(obat.getJumlah() + jumlah.intValue());
        repository.save(obat);
    }

    @Override
    public void prosesKeluar(Long targetId, BigDecimal jumlah, String keterangan)  {
        StokObat obat = repository.findById(targetId)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.STOK_OBAT, targetId));
        if (obat.getJumlah() < jumlah.intValue()) {
            throw new BadRequestException(Constant.STOCK_NOT_ENOUGH_PATTERN, Constant.OBAT);
        }
        obat.setJumlah(obat.getJumlah() - jumlah.intValue());
        repository.save(obat);
    }
}
