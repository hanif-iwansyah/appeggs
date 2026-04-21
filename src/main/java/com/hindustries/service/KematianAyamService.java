package com.hindustries.service;

import com.hindustries.base.BaseService;
import com.hindustries.dto.request.KematianAyamRequest;
import com.hindustries.dto.response.KematianAyamResponse;
import com.hindustries.entity.KelompokAyam;
import com.hindustries.entity.KematianAyam;
import com.hindustries.mapper.KematianAyamMapper;
import com.hindustries.repository.KelompokAyamRepository;
import com.hindustries.repository.KematianAyamRepository;
import com.hindustries.util.Constant;
import com.hindustries.util.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class KematianAyamService implements BaseService<KematianAyamRequest, KematianAyamResponse, Long> {
    
    private final KematianAyamRepository repository;
    private final KelompokAyamRepository kelompokAyamRepository;
    private final KematianAyamMapper mapper;

    public KematianAyamService(KematianAyamRepository repository, KelompokAyamRepository kelompokAyamRepository, KematianAyamMapper mapper) {
        this.repository = repository;
        this.kelompokAyamRepository = kelompokAyamRepository;
        this.mapper = mapper;
    }

    @Override
    public KematianAyamResponse create(KematianAyamRequest request) {
        KelompokAyam kelompokAyam = kelompokAyamRepository.findById(request.getKelompokAyamId())
                .orElseThrow(() -> new ResourceNotFoundException(Constant.KELOMPOK_AYAM, request.getKelompokAyamId()));
        KematianAyam entity = mapper.toEntity(request);
        entity.setKelompokAyam(kelompokAyam);
        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public KematianAyamResponse update(Long id, KematianAyamRequest request) {
        KelompokAyam kelompokAyam = kelompokAyamRepository.findById(request.getKelompokAyamId())
                .orElseThrow(() -> new ResourceNotFoundException(Constant.KELOMPOK_AYAM, request.getKelompokAyamId()));
        KematianAyam entity = repository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException(Constant.KEMATIAN_AYAM, id));
        mapper.updateEntityFromRequest(request, entity);
        entity.setKelompokAyam(kelompokAyam);
        return mapper.toResponse(repository.save(entity));    }

    @Override
    public List<KematianAyamResponse> findAll() {
        List<KematianAyam> lsEntity = repository.findAll();
        return mapper.toResponse(lsEntity);
    }

    @Override
    public KematianAyamResponse findById(Long id) {
        KematianAyam entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.KEMATIAN_AYAM, id));
        return mapper.toResponse(entity);
    }

    @Override
    public void delete(Long id) {
        repository.delete(repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.KEMATIAN_AYAM, id)));
    }
}
