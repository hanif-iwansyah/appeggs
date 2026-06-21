package com.hindustries.service.domain.operasional.inventory;

import com.hindustries.dto.response.domain.operasional.inventory.StokPakanAlertResponse;
import com.hindustries.entity.domain.operasional.inventory.StokPakan;
import com.hindustries.mapper.domain.operasional.inventory.StokPakanMapper;
import com.hindustries.repository.domain.operasional.inventory.StokPakanRepository;
import com.hindustries.util.BadRequestException;
import com.hindustries.util.Constant;
import com.hindustries.util.ResourceNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Component
public class StokPakanService implements InventarisStrategy {

    private final StokPakanRepository repository;

    public StokPakanService(StokPakanRepository repository, StokPakanMapper mapper) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<StokPakanAlertResponse> getAlert() {
        List<StokPakan> stokPakanList = repository.findBelowMinimum();

        return stokPakanList.stream()
                .map(stokPakan -> {
                    StokPakanAlertResponse alert = new StokPakanAlertResponse();
                    alert.setId(stokPakan.getId());
                    alert.setNamaPakan(stokPakan.getJenisPakan().getNamaPakan());
                    alert.setNamaGudang(stokPakan.getGudang().getNamaGudang());
                    alert.setJumlahKg(stokPakan.getStokMinimumKg());
                    alert.setStokMinimumKg(stokPakan.getStokMinimumKg().subtract(stokPakan.getJumlahKg()));
                    return alert;
                }).toList();
    }


    @Override
    public boolean isSupported(String kategori) {
        return Constant.PAKAN.equalsIgnoreCase(kategori);
    }

    @Override
    public void prosesMasuk(Long targetId, BigDecimal jumlah, String keterangan) {
        StokPakan pakan = repository.findById(targetId)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.STOK_PAKAN, targetId));
        pakan.setJumlahKg(pakan.getJumlahKg().add(jumlah));
        repository.save(pakan);
    }

    @Override
    public void prosesKeluar(Long targetId, BigDecimal jumlah, String keterangan) {
        StokPakan pakan = repository.findById(targetId)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.PAKAN, targetId));
        if (pakan.getJumlahKg().compareTo(jumlah) < 0) {
            throw new BadRequestException(Constant.STOCK_NOT_ENOUGH_PATTERN, Constant.PAKAN);
        }
        pakan.setJumlahKg(pakan.getJumlahKg().subtract(jumlah));
        repository.save(pakan);
    }
}
