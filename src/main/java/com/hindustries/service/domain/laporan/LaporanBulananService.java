package com.hindustries.service.domain.laporan;

import com.hindustries.base.BaseService;
import com.hindustries.dto.request.domain.laporan.LaporanBulananRequest;
import com.hindustries.dto.response.domain.laporan.LaporanBulananResponse;
import com.hindustries.entity.domain.master.Peternakan;
import com.hindustries.entity.domain.laporan.LaporanBulanan;
import com.hindustries.mapper.domain.laporan.LaporanBulananMapper;
import com.hindustries.repository.domain.master.PeternakanRepository;
import com.hindustries.repository.domain.laporan.LaporanBulananRepository;
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
