package com.hindustries.service.domain.master;

import com.hindustries.base.BaseServiceImpl;
import com.hindustries.dto.request.master.PeternakanRequest;
import com.hindustries.dto.response.master.PeternakanResponse;
import com.hindustries.entity.master.Peternakan;
import com.hindustries.mapper.master.PeternakanMapper;
import com.hindustries.repository.master.PeternakanRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class PeternakanService extends BaseServiceImpl<Peternakan, PeternakanRequest, PeternakanResponse, Long> {

    private final PeternakanRepository repository;
    private final PeternakanMapper mapper;

    public PeternakanService(PeternakanRepository repository,
                             PeternakanMapper mapper) {
        super(Peternakan.class);
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    protected JpaRepository<Peternakan, Long> getRepository() {
        return repository;
    }

    @Override
    protected PeternakanResponse mapToResponse(Peternakan peternakan) {
        return mapper.toResponse(peternakan);
    }

    @Override
    protected Peternakan mapToEntity(PeternakanRequest request) {
        return mapper.toEntity(request);
    }

    @Override
    protected void updateEntityFromReq(PeternakanRequest request, Peternakan entity) {
        mapper.updateEntityFromRequest(request, entity);
    }

}