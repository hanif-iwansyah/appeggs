package com.hindustries.service;

import com.hindustries.base.BaseService;
import com.hindustries.dto.request.PenggunaRequest;
import com.hindustries.dto.response.PenggunaResponse;
import com.hindustries.entity.Pengguna;
import com.hindustries.mapper.PenggunaMapper;
import com.hindustries.repository.PenggunaRepository;
import com.hindustries.util.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PenggunaService implements BaseService<PenggunaRequest, PenggunaResponse, Long> {

    private final PenggunaRepository repository;
    private final PenggunaMapper mapper;

    public PenggunaService(PenggunaRepository repository, PenggunaMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public PenggunaResponse create(PenggunaRequest request) {
        Pengguna entity = repository.save(mapper.toEntity(request));
        return mapper.toResponse(entity);
    }

    @Override
    public PenggunaResponse update(Long id, PenggunaRequest request) {
        Pengguna entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pengguna", id));
        mapper.updateEntityFromRequest(request, entity);
        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public List<PenggunaResponse> findAll() {
        List<Pengguna> lsEntity = repository.findAll();
        return mapper.toResponse(lsEntity);
    }

    @Override
    public PenggunaResponse findById(Long id) {
        Pengguna entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pengguna", id));
        return mapper.toResponse(entity);
    }

    @Override
    public void delete(Long id) {
        repository.delete(repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pengguna", id)));
    }
}
