package com.hindustries.service.domain.master;

import com.hindustries.base.BaseServiceImpl;
import com.hindustries.dto.request.domain.master.GudangRequest;
import com.hindustries.dto.response.domain.master.GudangResponse;
import com.hindustries.entity.domain.master.Gudang;
import com.hindustries.mapper.domain.master.GudangMapper;
import com.hindustries.repository.domain.master.GudangRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

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
