package com.hindustries.service.system;

import com.hindustries.base.BaseService;
import com.hindustries.dto.request.system.PeranRequest;
import com.hindustries.dto.response.system.PeranResponse;
import com.hindustries.entity.system.Peran;
import com.hindustries.mapper.system.PeranMapper;
import com.hindustries.repository.system.PeranRepository;
import com.hindustries.util.Constant;
import com.hindustries.util.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PeranService implements BaseService<PeranRequest, PeranResponse, Long> {

    private final PeranRepository repository;
    private final PeranMapper mapper;

    public PeranService(PeranRepository repository, PeranMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public PeranResponse create(PeranRequest request) {
        Peran entity = repository.save(mapper.toEntity(request));
        return mapper.toResponse(entity);
    }

    @Override
    public PeranResponse update(Long id, PeranRequest request) {
        Peran entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.PERAN, id));
        mapper.updateEntityFromRequest(request, entity);
        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public List<PeranResponse> findAll() {
        List<Peran> lsEntity = repository.findAll();
        return mapper.toResponse(lsEntity);
    }

    @Override
    public PeranResponse findById(Long id) {
        Peran entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.PERAN, id));
        return mapper.toResponse(entity);
    }

    @Override
    public void delete(Long id) {
        Peran entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.PERAN, id));
        repository.delete(entity);
    }
}
