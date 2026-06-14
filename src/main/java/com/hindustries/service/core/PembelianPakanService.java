package com.hindustries.service.core;

import com.hindustries.base.BaseService;

import com.hindustries.dto.request.core.PembelianPakanRequest;
import com.hindustries.dto.response.core.PembelianPakanResponse;
import com.hindustries.entity.master.Pemasok;
import com.hindustries.entity.core.PembelianPakan;
import com.hindustries.mapper.core.PembelianPakanMapper;
import com.hindustries.repository.PemasokRepository;
import com.hindustries.repository.core.PembelianPakanRepository;
import com.hindustries.util.Constant;
import com.hindustries.util.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PembelianPakanService implements BaseService<PembelianPakanRequest, PembelianPakanResponse, Long> {

    private final PembelianPakanRepository repository;
    private final PemasokRepository pemasokRepository;
    private final PembelianPakanMapper mapper;

    public PembelianPakanService(PembelianPakanRepository repository, PemasokRepository pemasokRepository, PembelianPakanMapper mapper) {
        this.repository = repository;
        this.pemasokRepository = pemasokRepository;
        this.mapper = mapper;
    }

    @Override
    public PembelianPakanResponse create(PembelianPakanRequest request) {
        Pemasok pemasok = pemasokRepository.findById(request.getPemasokId())
                .orElseThrow(() -> new ResourceNotFoundException(Constant.PEMASOK, request.getPemasokId()));
        PembelianPakan entity = mapper.toEntity(request);
        entity.setPemasok(pemasok);
        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public PembelianPakanResponse update(Long id, PembelianPakanRequest request) {
        PembelianPakan entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.PEMBELIAN_PAKAN, id));
        mapper.updateEntityFromRequest(request, entity);
        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public List<PembelianPakanResponse> findAll() {
        List<PembelianPakan> lsEntity = repository.findAll();
        return mapper.toResponse(lsEntity);
    }

    @Override
    public PembelianPakanResponse findById(Long id) {
        PembelianPakan entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.PEMBELIAN_PAKAN, id));
        return mapper.toResponse(entity);
    }

    @Override
    public void delete(Long id) {
        repository.delete(repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.PEMBELIAN_PAKAN, id)));
    }
}
