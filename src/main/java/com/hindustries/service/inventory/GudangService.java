package com.hindustries.service.inventory;

import com.hindustries.base.BaseService;
import com.hindustries.dto.request.inventory.GudangRequest;
import com.hindustries.dto.response.inventory.GudangResponse;
import com.hindustries.entity.inventory.Gudang;
import com.hindustries.mapper.inventory.GudangMapper;
import com.hindustries.repository.inventory.GudangRepository;
import com.hindustries.util.Constant;
import com.hindustries.util.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GudangService implements BaseService<GudangRequest, GudangResponse, Long> {

    private final GudangRepository repository;
    private final GudangMapper mapper;

    public GudangService(GudangRepository repository, GudangMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public GudangResponse create(GudangRequest request) {
        Gudang entity = repository.save(mapper.toEntity(request));
        return mapper.toResponse(entity);
    }

    @Override
    public GudangResponse update(Long id, GudangRequest request) {
        Gudang entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.GUDANG, id));
        mapper.updateEntityFromRequest(request, entity);
        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public List<GudangResponse> findAll() {
        List<Gudang> lsEntity = repository.findAll();
        return mapper.toResponse(lsEntity);
    }

    @Override
    public GudangResponse findById(Long id) {
        return mapper.toResponse(repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.GUDANG, id)));
    }

    @Override
    public void delete(Long id) {
        if (repository.existsById(id)) repository.deleteById(id);
        else throw new ResourceNotFoundException(Constant.GUDANG, id);
    }
}
