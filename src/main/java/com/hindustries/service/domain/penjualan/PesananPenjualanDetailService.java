package com.hindustries.service.domain.penjualan;

import com.hindustries.base.BaseService;
import com.hindustries.dto.request.commerce.PesananPenjualanDetailRequest;
import com.hindustries.dto.response.commerce.PesananPenjualanDetailResponse;
import com.hindustries.entity.commerce.PesananPenjualan;
import com.hindustries.entity.commerce.PesananPenjualanDetail;
import com.hindustries.mapper.commerce.PesananPenjualanDetailMapper;
import com.hindustries.repository.PesananPenjualanDetailRepository;
import com.hindustries.repository.PesananPenjualanRepository;
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
