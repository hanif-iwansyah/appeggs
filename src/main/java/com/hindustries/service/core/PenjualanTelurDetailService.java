package com.hindustries.service.core;

import com.hindustries.base.BaseService;
import com.hindustries.dto.request.core.PenjualanTelurDetailRequest;
import com.hindustries.dto.response.core.PenjualanTelurDetailResponse;
import com.hindustries.entity.core.PenjualanTelur;
import com.hindustries.entity.core.PenjualanTelurDetail;
import com.hindustries.mapper.core.PenjualanTelurDetailMapper;
import com.hindustries.repository.core.DetailPenjualanTelurRepository;
import com.hindustries.repository.core.PenjualanTelurRepository;
import com.hindustries.util.Constant;
import com.hindustries.util.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PenjualanTelurDetailService implements BaseService<PenjualanTelurDetailRequest, PenjualanTelurDetailResponse, Long> {

    private final DetailPenjualanTelurRepository repository;
    private final PenjualanTelurRepository penjualanTelurRepository;
    private final PenjualanTelurDetailMapper mapper;

    public PenjualanTelurDetailService(DetailPenjualanTelurRepository repository, PenjualanTelurRepository penjualanTelurRepository, PenjualanTelurDetailMapper mapper) {
        this.repository = repository;
        this.penjualanTelurRepository = penjualanTelurRepository;
        this.mapper = mapper;
    }

    @Override
    public PenjualanTelurDetailResponse create(PenjualanTelurDetailRequest request) {
        PenjualanTelur penjualanTelur = penjualanTelurRepository.findById(request.getPenjualanTelurId())
                .orElseThrow(() -> new ResourceNotFoundException(Constant.PESANAN_PENJUALAN, request.getPenjualanTelurId()));
        PenjualanTelurDetail entity = mapper.toEntity(request);
        entity.setPenjualanTelur(penjualanTelur);
        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public PenjualanTelurDetailResponse update(Long id, PenjualanTelurDetailRequest request) {
        PenjualanTelurDetail entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.DETAIL_PENJUALAN_TELUR, id));
        mapper.updateEntityFromRequest(request, entity);
        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public List<PenjualanTelurDetailResponse> findAll() {
        List<PenjualanTelurDetail> lsEntity = repository.findAll();
        return mapper.toResponse(lsEntity);
    }

    @Override
    public PenjualanTelurDetailResponse findById(Long id) {
        PenjualanTelurDetail entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.DETAIL_PENJUALAN_TELUR, id));
        return mapper.toResponse(entity);
    }

    @Override
    public void delete(Long id) {
        repository.delete(repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.DETAIL_PENJUALAN_TELUR, id)));
    }
}
