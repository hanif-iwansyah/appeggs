package com.hindustries.service.core;

import com.hindustries.base.BaseService;
import com.hindustries.dto.request.core.PengakiranAyamRequest;
import com.hindustries.dto.response.core.PengakiranAyamResponse;
import com.hindustries.entity.KelompokAyam;
import com.hindustries.entity.core.PengakiranAyam;
import com.hindustries.mapper.core.PengakiranAyamMapper;
import com.hindustries.repository.KelompokAyamRepository;
import com.hindustries.repository.core.PengakiranAyamRepository;
import com.hindustries.util.Constant;
import com.hindustries.util.ResourceNotFoundException;
import com.hindustries.util.StatusKelompok;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PengakiranAyamService implements BaseService<PengakiranAyamRequest, PengakiranAyamResponse, Long> {
    public final PengakiranAyamRepository repository;
    public final KelompokAyamRepository kelompokAyamRepository;
    public final PengakiranAyamMapper mapper;

    public PengakiranAyamService(PengakiranAyamRepository repository, KelompokAyamRepository kelompokAyamRepository, PengakiranAyamMapper mapper) {
        this.repository = repository;
        this.kelompokAyamRepository = kelompokAyamRepository;
        this.mapper = mapper;
    }

    @Transactional
    public PengakiranAyamResponse create(PengakiranAyamRequest request) {
        KelompokAyam kelompokAyam = kelompokAyamRepository.findById(request.getKelompokAyamId())
                .orElseThrow(() -> new ResourceNotFoundException(Constant.KELOMPOK_AYAM, request.getKelompokAyamId()));
        PengakiranAyam entity = mapper.toEntity(request);
        entity.setKelompokAyam(kelompokAyam);
        PengakiranAyam saved = repository.save(entity);

        Integer populasiAktual = kelompokAyamRepository.findPopulasiAktual(kelompokAyam.getId());
        if (populasiAktual != null && populasiAktual <= 0) {
            kelompokAyam.setStatusKelompok(StatusKelompok.SELESAI);
            kelompokAyamRepository.save(kelompokAyam);
        }
        return mapper.toResponse(saved);
    }

    @Override
    public PengakiranAyamResponse update(Long aLong, PengakiranAyamRequest request) {
        return null;
    }

    @Override
    public List<PengakiranAyamResponse> findAll() {
        return List.of();
    }

    @Override
    public PengakiranAyamResponse findById(Long aLong) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public List<PengakiranAyamResponse> createBatch(List<PengakiranAyamRequest> request) {
        return List.of();
    }
}
