package com.hindustries.service.domain.master;

import com.hindustries.base.BaseServiceImpl;
import com.hindustries.dto.request.system.PeranRequest;
import com.hindustries.dto.response.system.PeranResponse;
import com.hindustries.entity.system.Peran;
import com.hindustries.mapper.system.PeranMapper;
import com.hindustries.repository.system.PeranRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class PeranService extends BaseServiceImpl<Peran, PeranRequest, PeranResponse, Long> {

    private final PeranRepository repository;
    private final PeranMapper mapper;

    public PeranService(PeranRepository repository, PeranMapper mapper) {
        super(Peran.class);
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    protected JpaRepository<Peran, Long> getRepository() {
        return repository;
    }

    @Override
    protected PeranResponse mapToResponse(Peran peran) {
        return mapper.toResponse(peran);
    }

    @Override
    protected Peran mapToEntity(PeranRequest request) {
        return mapper.toEntity(request);
    }

    @Override
    protected void updateEntityFromReq(PeranRequest request, Peran entity) {
        mapper.updateEntityFromRequest(request, entity);
    }

}
