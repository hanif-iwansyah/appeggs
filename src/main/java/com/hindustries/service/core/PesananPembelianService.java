package com.hindustries.service.core;

import com.hindustries.base.BaseService;
import com.hindustries.dto.request.core.PesananPembelianRequest;
import com.hindustries.dto.response.core.PesananPembelianResponse;
import com.hindustries.entity.Pemasok;
import com.hindustries.entity.core.PesananPembelian;
import com.hindustries.mapper.core.PesananPembelianMapper;
import com.hindustries.repository.PemasokRepository;
import com.hindustries.repository.core.PesananPembelianRepository;
import com.hindustries.util.Constant;
import com.hindustries.util.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PesananPembelianService implements BaseService<PesananPembelianRequest, PesananPembelianResponse, Long> {

    private final PesananPembelianRepository repository;
    private final PemasokRepository pemasokRepository;
    private final PesananPembelianMapper mapper;

    public PesananPembelianService(PesananPembelianRepository repository, PemasokRepository pemasokRepository, PesananPembelianMapper mapper) {
        this.repository = repository;
        this.pemasokRepository = pemasokRepository;
        this.mapper = mapper;
    }

    @Override
    public PesananPembelianResponse create(PesananPembelianRequest request) {
        Pemasok pemasok = pemasokRepository.findById(request.getPemasokId())
                .orElseThrow(() -> new ResourceNotFoundException(Constant.PEMASOK, request.getPemasokId()));
        PesananPembelian entity = mapper.toEntity(request);
        entity.setPemasok(pemasok);
        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public PesananPembelianResponse update(Long id, PesananPembelianRequest request) {
        PesananPembelian entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.PESANAN_PEMBELIAN, id));
        mapper.updateEntityFromRequest(request, entity);
        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public List<PesananPembelianResponse> findAll() {
        List<PesananPembelian> lsEntity = repository.findAll();
        return mapper.toResponse(lsEntity);
    }

    @Override
    public PesananPembelianResponse findById(Long id) {
        PesananPembelian entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.PESANAN_PEMBELIAN, id));
        return mapper.toResponse(entity);
    }

    @Override
    public void delete(Long id) {
        repository.delete(repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.PESANAN_PEMBELIAN, id)));
    }
}
