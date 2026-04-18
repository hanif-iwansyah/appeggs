package com.hindustries.service;

import com.hindustries.base.BaseService;
import com.hindustries.dto.request.RasAyamRequest;
import com.hindustries.dto.response.RasAyamResponse;
import com.hindustries.entity.RasAyam;
import com.hindustries.mapper.RasAyamMapper;
import com.hindustries.repository.RasAyamRepository;
import com.hindustries.util.Constant;
import com.hindustries.util.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RasAyamService implements BaseService<RasAyamRequest, RasAyamResponse, Long> {

    private final RasAyamRepository repository;
    private final RasAyamMapper mapper;

    public RasAyamService(RasAyamRepository repository, RasAyamMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public RasAyamResponse create(RasAyamRequest request) {
        RasAyam entity = mapper.toEntity(request);
        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public RasAyamResponse update(Long id, RasAyamRequest request) {
        RasAyam entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.RAS_AYAM, id));
        mapper.updateEntityFromRequest(request, entity);
        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public List<RasAyamResponse> findAll() {
        return mapper.toResponse(repository.findAll());
    }

    @Override
    public RasAyamResponse findById(Long id) {
        return mapper.toResponse(repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.RAS_AYAM, id)));
    }

    @Override
    public void delete(Long id) {
        if (repository.existsById(id)) repository.deleteById(id);
        else throw new ResourceNotFoundException(Constant.RAS_AYAM, id);
    }
}
