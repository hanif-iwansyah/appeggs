package com.hindustries.service.domain_master_data;

import com.hindustries.base.BaseServiceImpl;
import com.hindustries.dto.request.master.RasAyamRequest;
import com.hindustries.dto.response.master.RasAyamResponse;
import com.hindustries.entity.master.RasAyam;
import com.hindustries.mapper.master.RasAyamMapper;
import com.hindustries.repository.master.RasAyamRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class RasAyamService extends BaseServiceImpl<RasAyam, RasAyamRequest, RasAyamResponse, Long> {

    private final RasAyamRepository repository;
    private final RasAyamMapper mapper;

    public RasAyamService(RasAyamRepository repository, RasAyamMapper mapper) {
        super(RasAyam.class);
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    protected JpaRepository<RasAyam, Long> getRepository() {
        return repository;
    }

    @Override
    protected RasAyamResponse mapToResponse(RasAyam rasAyam) {
        return mapper.toResponse(rasAyam);
    }

    @Override
    protected RasAyam mapToEntity(RasAyamRequest request) {
        return mapper.toEntity(request);
    }

    @Override
    protected void updateEntityFromReq(RasAyamRequest request, RasAyam entity) {
        mapper.updateEntityFromRequest(request, entity);
    }

}
