package com.hindustries.service.farm;

import com.hindustries.base.BaseServiceImpl;
import com.hindustries.dto.request.commerce.PengakiranAyamRequest;
import com.hindustries.dto.response.farm.PengakiranAyamResponse;
import com.hindustries.entity.farm.KelompokAyam;
import com.hindustries.entity.farm.PengakiranAyam;
import com.hindustries.entity.farm.StatusKelompok;
import com.hindustries.mapper.farm.PengakiranAyamMapper;
import com.hindustries.repository.farm.KelompokAyamRepository;
import com.hindustries.repository.farm.PengakiranAyamRepository;
import com.hindustries.util.Constant;
import com.hindustries.util.ResourceNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class PengakiranAyamService extends BaseServiceImpl<PengakiranAyam, PengakiranAyamRequest, PengakiranAyamResponse, Long> {

    private final PengakiranAyamRepository repository;
    private final PengakiranAyamMapper mapper;
    private final KelompokAyamRepository kelompokAyamRepository;

    public PengakiranAyamService(PengakiranAyamRepository repository, PengakiranAyamMapper mapper,
                                 KelompokAyamRepository kelompokAyamRepository) {
        super(PengakiranAyam.class);
        this.repository = repository;
        this.mapper = mapper;
        this.kelompokAyamRepository = kelompokAyamRepository;
    }

    @Override
    protected JpaRepository<PengakiranAyam, Long> getRepository() {
        return repository;
    }

    @Override
    protected PengakiranAyamResponse mapToResponse(PengakiranAyam entity) {
        return mapper.toResponse(entity);
    }

    @Override
    protected PengakiranAyam mapToEntity(PengakiranAyamRequest request) {
        return mapper.toEntity(request);
    }

    @Override
    protected void updateEntityFromReq(PengakiranAyamRequest request, PengakiranAyam entity) {
        mapper.updateEntityFromRequest(request, entity);
    }

    @Override
    protected void beforeCreate(PengakiranAyamRequest request, PengakiranAyam entity) {
        KelompokAyam kelompokAyam = kelompokAyamRepository.findById(request.getKelompokAyamId())
                .orElseThrow(() -> new ResourceNotFoundException(Constant.KELOMPOK_AYAM, request.getKelompokAyamId()));
        entity.setKelompokAyam(kelompokAyam);
    }

    @Override
    protected void afterCreate(PengakiranAyamRequest request, PengakiranAyam entity) {
        KelompokAyam kelompokAyam = entity.getKelompokAyam();
        Integer populasiAktual = kelompokAyamRepository.findPopulasiAktual(request.getKelompokAyamId());
        if (populasiAktual != null && populasiAktual <= 0) {
            kelompokAyam.setStatusKelompok(StatusKelompok.SELESAI);
            kelompokAyamRepository.save(kelompokAyam);
        }
    }

}
