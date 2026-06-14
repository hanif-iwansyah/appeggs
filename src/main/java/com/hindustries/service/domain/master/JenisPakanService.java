package com.hindustries.service.domain.master;

import com.hindustries.base.BaseServiceImpl;
import com.hindustries.dto.request.master.JenisPakanRequest;
import com.hindustries.dto.response.master.JenisPakanResponse;
import com.hindustries.entity.master.JenisPakan;
import com.hindustries.mapper.master.JenisPakanMapper;
import com.hindustries.repository.master.JenisPakanRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class JenisPakanService extends BaseServiceImpl<JenisPakan, JenisPakanRequest, JenisPakanResponse, Long> {

    private final JenisPakanRepository repository;
    private final JenisPakanMapper mapper;

    public JenisPakanService(JenisPakanRepository repository, JenisPakanMapper mapper) {
        super(JenisPakan.class);
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    protected JpaRepository<JenisPakan, Long> getRepository() {
        return repository;
    }

    @Override
    protected JenisPakanResponse mapToResponse(JenisPakan jenisPakan) {
        return mapper.toResponse(jenisPakan);
    }

    @Override
    protected JenisPakan mapToEntity(JenisPakanRequest request) {
        return mapper.toEntity(request);
    }

    @Override
    protected void updateEntityFromReq(JenisPakanRequest request, JenisPakan entity) {
        mapper.updateEntityFromRequest(request, entity);
    }

}
