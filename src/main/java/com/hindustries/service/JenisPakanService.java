package com.hindustries.service;

import com.hindustries.base.BaseService;
import com.hindustries.dto.request.JenisPakanRequest;
import com.hindustries.dto.response.JenisPakanResponse;
import com.hindustries.entity.JenisPakan;
import com.hindustries.mapper.JenisPakanMapper;
import com.hindustries.repository.JenisPakanRepository;
import com.hindustries.util.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class JenisPakanService implements BaseService<JenisPakanRequest, JenisPakanResponse, Long> {

    private final JenisPakanRepository repository;
    private final JenisPakanMapper mapper;

    public JenisPakanService(JenisPakanRepository repository, JenisPakanMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public JenisPakanResponse create(JenisPakanRequest request) {
        JenisPakan entity = repository.save(mapper.toEntity(request));
        return mapper.toResponse(entity);
    }

    @Override
    public JenisPakanResponse update(Long id, JenisPakanRequest request) {
        JenisPakan entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Jenis Pakan", id));
        mapper.updateEntityFromRequest(request, entity);
        repository.save(entity);
        return mapper.toResponse(entity);
    }

    @Override
    public List<JenisPakanResponse> findAll() {
        List<JenisPakan> lsEntity = repository.findAll();
        return mapper.toResponse(lsEntity);
    }

    @Override
    public JenisPakanResponse findById(Long id) {
        JenisPakan entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Jenis Pakan", id));
        return mapper.toResponse(entity);
    }

    @Override
    public void delete(Long id) {
        repository.delete(repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Jenis Pakan", id)));
    }

}
