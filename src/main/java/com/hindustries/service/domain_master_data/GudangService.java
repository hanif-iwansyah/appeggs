package com.hindustries.service.domain_master_data;

import com.hindustries.base.BaseService;
import com.hindustries.base.BaseServiceImpl;
import com.hindustries.dto.request.inventory.GudangRequest;
import com.hindustries.dto.response.inventory.GudangResponse;
import com.hindustries.entity.inventory.Gudang;
import com.hindustries.mapper.inventory.GudangMapper;
import com.hindustries.repository.inventory.GudangRepository;
import com.hindustries.util.Constant;
import com.hindustries.util.ResourceNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GudangService extends BaseServiceImpl<Gudang, GudangRequest, GudangResponse, Long> {

    private final GudangRepository repository;
    private final GudangMapper mapper;

    public GudangService(GudangRepository repository, GudangMapper mapper) {
        super(Gudang.class);
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    protected JpaRepository<Gudang, Long> getRepository() {
        return repository;
    }

    @Override
    protected GudangResponse mapToResponse(Gudang gudang) {
        return mapper.toResponse(gudang);
    }

    @Override
    protected Gudang mapToEntity(GudangRequest request) {
        return mapper.toEntity(request);
    }

    @Override
    protected void updateEntityFromReq(GudangRequest request, Gudang entity) {
        mapper.updateEntityFromRequest(request, entity);
    }
}
