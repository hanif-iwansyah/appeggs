package com.hindustries.service.domain.penjualan;

import com.hindustries.base.BaseService;
import com.hindustries.dto.request.domain.penjualan.PenjualanTelurDetailRequest;
import com.hindustries.dto.response.domain.penjualan.PenjualanTelurDetailResponse;
import com.hindustries.entity.domain.penjualan.PenjualanTelur;
import com.hindustries.entity.domain.penjualan.PenjualanTelurDetail;
import com.hindustries.mapper.domain.penjualan.PenjualanTelurDetailMapper;
import com.hindustries.repository.domain.penjualan.PenjualanTelurDetailRepository;
import com.hindustries.repository.domain.penjualan.PenjualanTelurRepository;
import com.hindustries.util.Constant;
import com.hindustries.util.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PenjualanTelurDetailService implements BaseService<PenjualanTelurDetailRequest, PenjualanTelurDetailResponse, Long> {

    private final PenjualanTelurDetailRepository repository;
    private final PenjualanTelurRepository penjualanTelurRepository;
    private final PenjualanTelurDetailMapper mapper;

    public PenjualanTelurDetailService(PenjualanTelurDetailRepository repository, PenjualanTelurRepository penjualanTelurRepository, PenjualanTelurDetailMapper mapper) {
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
