package com.hindustries.service.farm;

import com.hindustries.base.BaseService;
import com.hindustries.dto.request.farm.GradingTelurRequest;
import com.hindustries.dto.response.farm.GradingTelurResponse;
import com.hindustries.entity.farm.GradingTelur;
import com.hindustries.entity.farm.ProduksiTelur;
import com.hindustries.mapper.farm.GradingTelurMapper;
import com.hindustries.mapper.farm.ProduksiTelurMapper;
import com.hindustries.repository.GradingTelurRepository;
import com.hindustries.repository.ProduksiTelurRepository;
import com.hindustries.util.Constant;
import com.hindustries.util.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GradingTelurService implements BaseService<GradingTelurRequest, GradingTelurResponse, Long> {

    private final GradingTelurRepository repository;
    private final ProduksiTelurRepository produksiTelurRepository;
    private final GradingTelurMapper mapper;
    private final ProduksiTelurMapper produksiTelurMapper;

    public GradingTelurService(GradingTelurRepository repository, ProduksiTelurRepository produksiTelurRepository, GradingTelurMapper mapper, ProduksiTelurMapper produksiTelurMapper) {
        this.repository = repository;
        this.produksiTelurRepository = produksiTelurRepository;
        this.mapper = mapper;
        this.produksiTelurMapper = produksiTelurMapper;
    }

    @Override
    public GradingTelurResponse create(GradingTelurRequest request) {
        ProduksiTelur produksiTelur = produksiTelurRepository.findById(request.getProduksiTelurId())
                .orElseThrow(() -> new ResourceNotFoundException(Constant.PRODUKSI_TELUR, request.getProduksiTelurId()));
        GradingTelur entity = mapper.toEntity(request);
        entity.setProduksiTelur(produksiTelur);
        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public GradingTelurResponse update(Long id, GradingTelurRequest request) {
        GradingTelur entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.GRADING_TELUR, id));
        ProduksiTelur produksiTelur = produksiTelurRepository.findById(request.getProduksiTelurId())
                .orElseThrow(() -> new ResourceNotFoundException(Constant.PRODUKSI_TELUR, request.getProduksiTelurId()));
        entity.setProduksiTelur(produksiTelur);
        entity.setGradeA(request.getGradeA());
        entity.setGradeB(request.getGradeB());
        entity.setGradeC(request.getGradeC());
        mapper.updateEntityFromRequest(request, entity);
        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public List<GradingTelurResponse> findAll() {
        List<GradingTelur> lsEntity = repository.findAll();
        return mapper.toResponse(lsEntity);
    }

    @Override
    public GradingTelurResponse findById(Long id) {
        return mapper.toResponse(repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.GRADING_TELUR, id)));
    }

    @Override
    public void delete(Long id) {
        repository.delete(repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.GRADING_TELUR, id)));
    }
}
