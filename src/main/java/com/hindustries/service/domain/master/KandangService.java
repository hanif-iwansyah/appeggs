package com.hindustries.service.domain.master;

import com.hindustries.base.BaseServiceImpl;
import com.hindustries.dto.request.master.KandangRequest;
import com.hindustries.dto.response.master.KandangResponse;
import com.hindustries.entity.master.Kandang;
import com.hindustries.entity.master.Peternakan;
import com.hindustries.mapper.master.KandangMapper;
import com.hindustries.mapper.master.PeternakanMapper;
import com.hindustries.repository.master.KandangRepository;
import com.hindustries.repository.master.PeternakanRepository;
import com.hindustries.util.Constant;
import com.hindustries.util.ResourceNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class KandangService extends BaseServiceImpl<Kandang, KandangRequest, KandangResponse, Long> {

    private final KandangRepository repository;
    private final PeternakanRepository peternakanRepository;
    private final KandangMapper mapper;

    public KandangService(KandangRepository repository, PeternakanRepository peternakanRepository, KandangMapper mapper, PeternakanMapper peternakanMapper) {
        super(Kandang.class);
        this.repository = repository;
        this.peternakanRepository = peternakanRepository;
        this.mapper = mapper;
    }

    @Override
    protected JpaRepository<Kandang, Long> getRepository() {
        return repository;
    }

    @Override
    protected KandangResponse mapToResponse(Kandang kandang) {
        return mapper.toResponse(kandang);
    }

    @Override
    protected Kandang mapToEntity(KandangRequest request) {
        return mapper.toEntity(request);
    }

    @Override
    protected void updateEntityFromReq(KandangRequest request, Kandang entity) {
        mapper.updateEntityFromRequest(request, entity);
    }

    @Override
    protected void beforeCreate(KandangRequest request, Kandang entity) {
        Peternakan peternakan = peternakanRepository.findById(request.getPeternakanId())
                .orElseThrow(() -> new ResourceNotFoundException(Constant.PETERNAKAN, request.getPeternakanId()));
        entity.setPeternakan(peternakan);
    }

    @Override
    protected void beforeUpdate(KandangRequest request, Kandang entity) {
        Peternakan peternakan = peternakanRepository.findById(request.getPeternakanId())
                .orElseThrow(() -> new ResourceNotFoundException(Constant.PETERNAKAN, request.getPeternakanId()));
        entity.setPeternakan(peternakan);
    }

}