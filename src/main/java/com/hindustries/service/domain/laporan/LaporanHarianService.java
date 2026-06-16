package com.hindustries.service.domain.laporan;

import com.hindustries.base.BaseService;
import com.hindustries.dto.request.domain.laporan.LaporanHarianRequest;
import com.hindustries.dto.response.domain.laporan.LaporanHarianResponse;
import com.hindustries.entity.domain.master.Peternakan;
import com.hindustries.entity.domain.laporan.LaporanHarian;
import com.hindustries.mapper.domain.laporan.LaporanHarianMapper;
import com.hindustries.repository.domain.master.PeternakanRepository;
import com.hindustries.repository.domain.laporan.LaporanHarianRepository;
import com.hindustries.util.Constant;
import com.hindustries.util.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LaporanHarianService implements BaseService<LaporanHarianRequest, LaporanHarianResponse, Long> {

    private final LaporanHarianRepository repository;
    private final PeternakanRepository peternakanRepository;
    private final LaporanHarianMapper mapper;

    public LaporanHarianService(LaporanHarianRepository repository, PeternakanRepository peternakanRepository, LaporanHarianMapper mapper) {
        this.repository = repository;
        this.peternakanRepository = peternakanRepository;
        this.mapper = mapper;
    }


    @Override
    public LaporanHarianResponse create(LaporanHarianRequest request) {
        Peternakan peternakan = peternakanRepository.findById(request.getPeternakanId())
                .orElseThrow(() -> new ResourceNotFoundException(Constant.PETERNAKAN, request.getPeternakanId()));
        LaporanHarian entity = mapper.toEntity(request);
        entity.setPeternakan(peternakan);
        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public LaporanHarianResponse update(Long id, LaporanHarianRequest request) {
        LaporanHarian entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.LAPORAN_HARIAN, id));
        mapper.updateEntityFromRequest(request, entity);
        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public List<LaporanHarianResponse> findAll() {
        List<LaporanHarian> lsEntity = repository.findAll();
        return mapper.toResponse(lsEntity);
    }

    @Override
    public LaporanHarianResponse findById(Long id) {
        LaporanHarian entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.LAPORAN_HARIAN, id));
        return mapper.toResponse(entity);
    }

    @Override
    public void delete(Long id) {
        repository.delete(repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.LAPORAN_HARIAN, id)));
    }
}
