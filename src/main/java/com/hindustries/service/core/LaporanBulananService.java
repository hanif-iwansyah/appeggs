package com.hindustries.service.core;

import com.hindustries.base.BaseService;
import com.hindustries.dto.request.core.LaporanBulananRequest;
import com.hindustries.dto.response.core.LaporanBulananResponse;
import com.hindustries.entity.master.Peternakan;
import com.hindustries.entity.core.LaporanBulanan;
import com.hindustries.mapper.core.LaporanBulananMapper;
import com.hindustries.repository.PeternakanRepository;
import com.hindustries.repository.core.LaporanBulananRepository;
import com.hindustries.util.Constant;
import com.hindustries.util.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LaporanBulananService implements BaseService<LaporanBulananRequest, LaporanBulananResponse, Long> {

    private final LaporanBulananRepository repository;
    private final PeternakanRepository peternakanRepository;
    private final LaporanBulananMapper mapper;

    public LaporanBulananService(LaporanBulananRepository repository, PeternakanRepository peternakanRepository, LaporanBulananMapper mapper) {
        this.repository = repository;
        this.peternakanRepository = peternakanRepository;
        this.mapper = mapper;
    }

    @Override
    public LaporanBulananResponse create(LaporanBulananRequest request) {
        Peternakan peternakan = peternakanRepository.findById(request.getPeternakanId())
                .orElseThrow(() -> new ResourceNotFoundException(Constant.PETERNAKAN, request.getPeternakanId()));
        LaporanBulanan entity = mapper.toEntity(request);
        entity.setPeternakan(peternakan);
        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public LaporanBulananResponse update(Long id, LaporanBulananRequest request) {
        LaporanBulanan entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.LAPORAN_BULANAN, id));
        mapper.updateEntityFromRequest(request, entity);
        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public List<LaporanBulananResponse> findAll() {
        List<LaporanBulanan> lsEntity = repository.findAll();
        return mapper.toResponse(lsEntity);
    }

    @Override
    public LaporanBulananResponse findById(Long id) {
        LaporanBulanan entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.LAPORAN_BULANAN, id));
        return mapper.toResponse(entity);
    }

    @Override
    public void delete(Long id) {
        repository.delete(repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.LAPORAN_BULANAN, id)));
    }
}
