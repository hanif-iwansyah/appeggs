package com.hindustries.service;

import com.hindustries.base.BaseService;
import com.hindustries.dto.request.StokObatRequest;
import com.hindustries.dto.response.StokObatResponse;
import com.hindustries.entity.StokObat;
import com.hindustries.mapper.StokObatMapper;
import com.hindustries.repository.StokObatRepository;
import com.hindustries.util.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StokObatService implements BaseService<StokObatRequest, StokObatResponse, Long> {

    private final StokObatRepository repository;
    private final StokObatMapper mapper;

    public StokObatService(StokObatRepository repository, StokObatMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public StokObatResponse create(StokObatRequest request) {
        StokObat entity = repository.save(mapper.toEntity(request));
        return mapper.toResponse(entity);
    }

    @Override
    public StokObatResponse update(Long id, StokObatRequest request) {
        StokObat entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Stok Obat", id));
        mapper.updateEntityFromRequest(request, entity);
        repository.save(entity);
        return mapper.toResponse(entity);
    }

    @Override
    public List<StokObatResponse> findAll() {
        return mapper.toResponse(repository.findAll());
    }

    @Override
    public StokObatResponse findById(Long id) {
        return mapper.toResponse(repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Stok Obat", id)));
    }

    @Override
    public void delete(Long id) {
        repository.delete(repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Stok Obat", id)));
    }
}
