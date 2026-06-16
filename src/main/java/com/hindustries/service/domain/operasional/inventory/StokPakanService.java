package com.hindustries.service.domain.operasional.inventory;

import com.hindustries.dto.response.domain.operasional.inventory.StokPakanAlertResponse;
import com.hindustries.entity.domain.operasional.inventory.StokPakan;
import com.hindustries.mapper.domain.operasional.inventory.StokPakanMapper;
import com.hindustries.repository.domain.operasional.inventory.StokPakanRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class StokPakanService {

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


}
