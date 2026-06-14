package com.hindustries.service.domain_master_data;

import com.hindustries.base.BaseServiceImpl;
import com.hindustries.dto.request.master.PemasokRequest;
import com.hindustries.dto.response.master.PemasokResponse;
import com.hindustries.entity.master.Pemasok;
import com.hindustries.mapper.master.PemasokMapper;
import com.hindustries.repository.master.PemasokRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class PemasokService extends BaseServiceImpl<Pemasok, PemasokRequest, PemasokResponse, Long> {

    private final PemasokRepository repository;
    private final PemasokMapper mapper;

    public PemasokService(PemasokRepository repository, PemasokMapper mapper) {
        super(Pemasok.class);
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    protected JpaRepository<Pemasok, Long> getRepository() {
        return repository;
    }

    @Override
    protected PemasokResponse mapToResponse(Pemasok pemasok) {
        return mapper.toResponse(pemasok);
    }

    @Override
    protected Pemasok mapToEntity(PemasokRequest request) {
        return mapper.toEntity(request);
    }

    @Override
    protected void updateEntityFromReq(PemasokRequest request, Pemasok entity) {
        mapper.updateEntityFromRequest(request, entity);
    }

}
