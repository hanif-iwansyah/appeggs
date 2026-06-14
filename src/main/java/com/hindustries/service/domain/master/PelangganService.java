package com.hindustries.service.domain.master;

import com.hindustries.base.BaseServiceImpl;
import com.hindustries.dto.request.master.PelangganRequest;
import com.hindustries.dto.response.master.PelangganResponse;
import com.hindustries.entity.master.Pelanggan;
import com.hindustries.mapper.master.PelangganMapper;
import com.hindustries.repository.master.PelangganRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class PelangganService extends BaseServiceImpl<Pelanggan, PelangganRequest, PelangganResponse, Long> {

    private final PelangganRepository repository;
    private final PelangganMapper mapper;

    public PelangganService(PelangganRepository repository, PelangganMapper mapper) {
        super(Pelanggan.class);
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    protected JpaRepository<Pelanggan, Long> getRepository() {
        return repository;
    }

    @Override
    protected PelangganResponse mapToResponse(Pelanggan pelanggan) {
        return mapper.toResponse(pelanggan);
    }

    @Override
    protected Pelanggan mapToEntity(PelangganRequest request) {
        return mapper.toEntity(request);
    }

    @Override
    protected void updateEntityFromReq(PelangganRequest request, Pelanggan entity) {
        mapper.upadateEntityFromRequest(request, entity);
    }

}
