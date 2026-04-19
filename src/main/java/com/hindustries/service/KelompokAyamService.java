package com.hindustries.service;

import com.hindustries.base.BaseService;
import com.hindustries.dto.request.KelompokAyamRequest;
import com.hindustries.dto.response.KelompokAyamResponse;
import com.hindustries.entity.Kandang;
import com.hindustries.entity.KelompokAyam;
import com.hindustries.entity.RasAyam;
import com.hindustries.mapper.KelompokAyamMapper;
import com.hindustries.repository.KandangRepository;
import com.hindustries.repository.KelompokAyamRepository;
import com.hindustries.repository.RasAyamRepository;
import com.hindustries.util.Constant;
import com.hindustries.util.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KelompokAyamService implements BaseService<KelompokAyamRequest, KelompokAyamResponse, Long> {

    private final KelompokAyamRepository repository;
    private final KandangRepository kandangRepository;
    private final RasAyamRepository rasAyamRepository;
    private final KelompokAyamMapper mapper;

    public KelompokAyamService(KelompokAyamRepository repository, KandangRepository kandangRepository, RasAyamRepository rasAyamRepository, KelompokAyamMapper mapper) {
        this.repository = repository;
        this.kandangRepository = kandangRepository;
        this.rasAyamRepository = rasAyamRepository;
        this.mapper = mapper;
    }

    @Override
    public KelompokAyamResponse create(KelompokAyamRequest request) {
        Kandang kandang = kandangRepository.findById(request.getKandangId())
                .orElseThrow(() -> new ResourceNotFoundException(Constant.KANDANG, request.getKandangId()));
        RasAyam rasAyam = rasAyamRepository.findById(request.getRasId())
                .orElseThrow(() -> new ResourceNotFoundException(Constant.RAS_AYAM, request.getRasId()));
        KelompokAyam entity = mapper.toEntity(request);
        entity.setKandang(kandang);
        entity.setRas(rasAyam);
        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public KelompokAyamResponse update(Long id, KelompokAyamRequest request) {
        Kandang kandang = kandangRepository.findById(request.getKandangId())
                .orElseThrow(() -> new ResourceNotFoundException(Constant.KANDANG, request.getKandangId()));
        RasAyam rasAyam = rasAyamRepository.findById(request.getRasId())
                .orElseThrow(() -> new ResourceNotFoundException(Constant.RAS_AYAM, request.getRasId()));
        KelompokAyam entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.KELOMPOK_AYAM, id));
        mapper.updateEntityFromRequest(request, entity);
        entity.setKandang(kandang);
        entity.setRas(rasAyam);
        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public List<KelompokAyamResponse> findAll() {
        List<KelompokAyam> lsEntity = repository.findAll();
        return mapper.toResponse(lsEntity);
    }

    @Override
    public KelompokAyamResponse findById(Long id) {
        KelompokAyam entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.KELOMPOK_AYAM, id));
        return mapper.toResponse(entity);
    }

    @Override
    public void delete(Long id) {
        repository.delete(repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.KELOMPOK_AYAM, id)));
    }
}
