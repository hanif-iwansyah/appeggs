package com.hindustries.service.domain.master;

import com.hindustries.base.BaseServiceImpl;
import com.hindustries.dto.request.system.PenggunaRequest;
import com.hindustries.dto.response.system.PenggunaResponse;
import com.hindustries.entity.system.Pengguna;
import com.hindustries.entity.system.Peran;
import com.hindustries.mapper.system.PenggunaMapper;
import com.hindustries.repository.PenggunaRepository;
import com.hindustries.repository.PeranRepository;
import com.hindustries.util.Constant;
import com.hindustries.util.ResourceNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class PenggunaService extends BaseServiceImpl<Pengguna, PenggunaRequest, PenggunaResponse, Long> {

    private final PenggunaRepository repository;
    private final PeranRepository peranRepository;
    private final PenggunaMapper mapper;

    public PenggunaService(PenggunaRepository repository, PeranRepository peranRepository, PenggunaMapper mapper) {
        super(Pengguna.class);
        this.repository = repository;
        this.peranRepository = peranRepository;
        this.mapper = mapper;
    }

    @Override
    protected JpaRepository<Pengguna, Long> getRepository() {
        return repository;
    }

    @Override
    protected PenggunaResponse mapToResponse(Pengguna pengguna) {
        return mapper.toResponse(pengguna);
    }

    @Override
    protected Pengguna mapToEntity(PenggunaRequest request) {
        return mapper.toEntity(request);
    }

    @Override
    protected void updateEntityFromReq(PenggunaRequest request, Pengguna entity) {
        mapper.updateEntityFromRequest(request, entity);
    }

    @Override
    protected void beforeCreate(PenggunaRequest request, Pengguna entity) {
        Peran peran = peranRepository.findById(request.getPeranId())
                .orElseThrow(() -> new ResourceNotFoundException(Constant.PERAN, request.getPeranId()));
        entity.setPeran(peran);
    }

    @Override
    protected void beforeUpdate(PenggunaRequest request, Pengguna entity) {
        Peran peran = peranRepository.findById(request.getPeranId())
                .orElseThrow(() -> new ResourceNotFoundException(Constant.PERAN, request.getPeranId()));
        entity.setPeran(peran);
    }

}
