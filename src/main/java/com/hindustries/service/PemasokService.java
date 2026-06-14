package com.hindustries.service;

import com.hindustries.base.BaseService;
import com.hindustries.dto.request.PemasokRequest;
import com.hindustries.dto.response.PemasokResponse;
import com.hindustries.entity.master.Pemasok;
import com.hindustries.mapper.PemasokMapper;
import com.hindustries.repository.PemasokRepository;
import com.hindustries.util.Constant;
import com.hindustries.util.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PemasokService implements BaseService<PemasokRequest, PemasokResponse, Long> {

    private final PemasokRepository repository;
    private final PemasokMapper mapper;

    public PemasokService(PemasokRepository repository, PemasokMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public PemasokResponse create(PemasokRequest request) {
        Pemasok entity = repository.save(mapper.toEntity(request));
        return mapper.toResponse(entity);
    }

    @Override
    public PemasokResponse update(Long id, PemasokRequest request) {
        Pemasok entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.PEMASOK, id));
        mapper.updateEntityFromRequest(request, entity);
        repository.save(entity);
        return mapper.toResponse(entity);
    }

    @Override
    public List<PemasokResponse> findAll() {
        List<Pemasok> lsEntity = repository.findAll();
        return mapper.toResponse(lsEntity);
    }

    @Override
    public PemasokResponse findById(Long id) {
        Pemasok entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.PEMASOK, id));
        return mapper.toResponse(entity);
    }

    @Override
    public void delete(Long id) {
        repository.delete(repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.PEMASOK, id)));
    }

}
