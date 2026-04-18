package com.hindustries.service;

import com.hindustries.base.BaseService;
import com.hindustries.dto.request.PeternakanRequest;
import com.hindustries.dto.response.PeternakanResponse;
import com.hindustries.entity.Peternakan;
import com.hindustries.mapper.PeternakanMapper;
import com.hindustries.repository.PeternakanRepository;
import com.hindustries.util.Constant;
import com.hindustries.util.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PeternakanService implements BaseService<PeternakanRequest, PeternakanResponse, Long> {

    private final PeternakanRepository repository;
    private final PeternakanMapper mapper;

    public PeternakanService(PeternakanRepository repository,
                             PeternakanMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public PeternakanResponse create(PeternakanRequest request) {
        Peternakan entity = mapper.toEntity(request);
        Peternakan saved = repository.save(entity);
        return mapper.toResponse(saved);
    }

    @Override
    public PeternakanResponse update(Long id, PeternakanRequest request) {
        Peternakan entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.PETERNAKAN, id));
        entity.setNamaPeternakan(request.getNamaPeternakan());
        entity.setLokasi(request.getLokasi());
        entity.setNamaPemilik(request.getNamaPemilik());
        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public List<PeternakanResponse> findAll() {
        List<Peternakan> lsEntity = repository.findAll();
        return mapper.toResponse(lsEntity);
    }

    @Override
    public PeternakanResponse findById(Long id) {
        Peternakan entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.PETERNAKAN, id));
        return mapper.toResponse(entity);
    }

    @Override
    public void delete(Long id) {
        Peternakan entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.PETERNAKAN, id));
        repository.deleteById(entity.getId());
    }

    private Peternakan findEntityById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.PETERNAKAN, id));
    }

}