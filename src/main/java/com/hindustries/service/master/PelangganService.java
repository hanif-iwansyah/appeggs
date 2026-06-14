package com.hindustries.service.master;

import com.hindustries.base.BaseService;
import com.hindustries.dto.request.master.PelangganRequest;
import com.hindustries.dto.response.master.PelangganResponse;
import com.hindustries.entity.master.Pelanggan;
import com.hindustries.mapper.master.PelangganMapper;
import com.hindustries.repository.master.PelangganRepository;
import com.hindustries.util.Constant;
import com.hindustries.util.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PelangganService implements BaseService<PelangganRequest, PelangganResponse, Long> {

    private final PelangganRepository repository;
    private final PelangganMapper mapper;

    public PelangganService(PelangganRepository repository, PelangganMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public PelangganResponse create(PelangganRequest request) {
        Pelanggan entity = repository.save(mapper.toEntity(request));
        return mapper.toResponse(entity);
    }

    @Override
    public PelangganResponse update(Long id, PelangganRequest request) {
        Pelanggan entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.PELANGGAN, id));
        mapper.upadateEntityFromRequest(request, entity);
        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public List<PelangganResponse> findAll() {
        List<Pelanggan> lsEntity = repository.findAll();
        return mapper.toResponse(lsEntity);
    }

    @Override
    public PelangganResponse findById(Long id) {
        return mapper.toResponse(repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.PELANGGAN, id)));
    }

    @Override
    public void delete(Long id) {
        repository.delete(repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.PELANGGAN, id)));
    }
}
