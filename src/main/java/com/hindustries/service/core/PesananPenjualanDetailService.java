package com.hindustries.service.core;

import com.hindustries.base.BaseService;
import com.hindustries.dto.request.core.PesananPenjualanDetailRequest;
import com.hindustries.dto.response.core.PesananPenjualanDetailResponse;
import com.hindustries.entity.core.PesananPenjualan;
import com.hindustries.entity.core.PesananPenjualanDetail;
import com.hindustries.mapper.core.PesananPenjualanDetailMapper;
import com.hindustries.repository.core.PesananPenjualanDetailRepository;
import com.hindustries.repository.core.PesananPenjualanRepository;
import com.hindustries.util.Constant;
import com.hindustries.util.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PesananPenjualanDetailService implements BaseService<PesananPenjualanDetailRequest, PesananPenjualanDetailResponse, Long> {

    private final PesananPenjualanDetailRepository repository;
    private final PesananPenjualanRepository pesananPenjualanRepository;
    private final PesananPenjualanDetailMapper mapper;

    public PesananPenjualanDetailService(PesananPenjualanDetailRepository repository, PesananPenjualanRepository pesananPenjualanRepository, PesananPenjualanDetailMapper mapper) {
        this.repository = repository;
        this.pesananPenjualanRepository = pesananPenjualanRepository;
        this.mapper = mapper;
    }

    @Override
    public PesananPenjualanDetailResponse create(PesananPenjualanDetailRequest request) {
        PesananPenjualan pesananPenjualan = pesananPenjualanRepository.findById(request.getPesananPenjualanId())
                .orElseThrow(() -> new ResourceNotFoundException(Constant.PESANAN_PENJUALAN, request.getPesananPenjualanId()));
        PesananPenjualanDetail entity = mapper.toEntity(request);
        entity.setPesananPenjualan(pesananPenjualan);
        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public PesananPenjualanDetailResponse update(Long id, PesananPenjualanDetailRequest request) {
        PesananPenjualanDetail entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.PESANAN_PENJUALAN_DETAIL, id));
        mapper.updateEntityFromRequest(request, entity);
        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public List<PesananPenjualanDetailResponse> findAll() {
        List<PesananPenjualanDetail> lsEntity = repository.findAll();
        return mapper.toResponse(lsEntity);
    }

    @Override
    public PesananPenjualanDetailResponse findById(Long id) {
        PesananPenjualanDetail entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.PESANAN_PENJUALAN_DETAIL, id));
        return mapper.toResponse(entity);
    }

    @Override
    public void delete(Long id) {
        repository.delete(repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.PESANAN_PENJUALAN_DETAIL, id)));
    }
}
