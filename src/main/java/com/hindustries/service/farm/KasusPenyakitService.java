package com.hindustries.service.farm;

import com.hindustries.base.BaseService;
import com.hindustries.dto.request.farm.KasusPenyakitRequest;
import com.hindustries.dto.response.farm.KasusPenyakitResponse;
import com.hindustries.entity.farm.KasusPenyakit;
import com.hindustries.entity.farm.KelompokAyam;
import com.hindustries.mapper.farm.KasusPenyakitMapper;
import com.hindustries.repository.KasusPenyakitRepository;
import com.hindustries.repository.KelompokAyamRepository;
import com.hindustries.util.Constant;
import com.hindustries.util.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KasusPenyakitService implements BaseService<KasusPenyakitRequest, KasusPenyakitResponse, Long> {

    private final KasusPenyakitRepository repository;
    private final KelompokAyamRepository kelompokAyamRepository;
    private final KasusPenyakitMapper mapper;

    public KasusPenyakitService(KasusPenyakitRepository repository, KelompokAyamRepository kelompokAyamRepository, KasusPenyakitMapper mapper) {
        this.repository = repository;
        this.kelompokAyamRepository = kelompokAyamRepository;
        this.mapper = mapper;
    }

    @Override
    public KasusPenyakitResponse create(KasusPenyakitRequest request) {
        KelompokAyam kelompokAyam = kelompokAyamRepository.findById(request.getKelompokAyamId())
                .orElseThrow(() -> new ResourceNotFoundException(Constant.KELOMPOK_AYAM, request.getKelompokAyamId()));
        KasusPenyakit entity = mapper.toEntity(request);
        entity.setKelompokAyam(kelompokAyam);
        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public KasusPenyakitResponse update(Long id, KasusPenyakitRequest request) {
        KelompokAyam kelompokAyam = kelompokAyamRepository.findById(request.getKelompokAyamId())
                .orElseThrow(() -> new ResourceNotFoundException(Constant.KELOMPOK_AYAM, request.getKelompokAyamId()));
        KasusPenyakit entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.KASUS_PENYAKIT, id));
        mapper.updateEntityFromRequest(request, entity);
        entity.setKelompokAyam(kelompokAyam);
        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public List<KasusPenyakitResponse> findAll() {
        List<KasusPenyakit> lsEntity = repository.findAll();
        return mapper.toResponse(lsEntity);
    }

    @Override
    public KasusPenyakitResponse findById(Long id) {
        KasusPenyakit entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.KASUS_PENYAKIT, id));
        return mapper.toResponse(entity);
    }

    @Override
    public void delete(Long id) {
        repository.delete(repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.KASUS_PENYAKIT, id)));
    }
}
