package com.hindustries.service.domain.pembelian;

import com.hindustries.base.BaseService;

import com.hindustries.dto.request.domain.pembelian.PembelianPakanRequest;
import com.hindustries.dto.response.domain.pembelian.PembelianPakanResponse;
import com.hindustries.entity.domain.master.Pemasok;
import com.hindustries.entity.domain.pembelian.PembelianPakan;
import com.hindustries.mapper.domain.pembelian.PembelianPakanMapper;
import com.hindustries.repository.domain.master.PemasokRepository;
import com.hindustries.repository.domain.pembelian.PembelianPakanRepository;
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
