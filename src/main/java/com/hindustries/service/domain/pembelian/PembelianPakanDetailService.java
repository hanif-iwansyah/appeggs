package com.hindustries.service.domain.pembelian;

import com.hindustries.base.BaseService;

import com.hindustries.dto.request.commerce.PembelianPakanDetailRequest;
import com.hindustries.dto.response.commerce.PembelianPakanDetailResponse;
import com.hindustries.entity.master.JenisPakan;
import com.hindustries.entity.commerce.PembelianPakan;
import com.hindustries.entity.commerce.PembelianPakanDetail;
import com.hindustries.mapper.commerce.PembelianPakanDetailMapper;
import com.hindustries.repository.JenisPakanRepository;
import com.hindustries.repository.PembelianPakanDetailRepository;
import com.hindustries.repository.PembelianPakanRepository;
import com.hindustries.util.Constant;
import com.hindustries.util.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PembelianPakanDetailService implements BaseService<PembelianPakanDetailRequest, PembelianPakanDetailResponse, Long> {

    private final PembelianPakanDetailRepository repository;
    private final PembelianPakanRepository pembelianPakanRepository;
    private final JenisPakanRepository jenisPakanRepository;
    private final PembelianPakanDetailMapper mapper;

    public PembelianPakanDetailService(PembelianPakanDetailRepository repository, PembelianPakanRepository pembelianPakanRepository, JenisPakanRepository jenisPakanRepository, PembelianPakanDetailMapper mapper) {
        this.repository = repository;
        this.pembelianPakanRepository = pembelianPakanRepository;
        this.jenisPakanRepository = jenisPakanRepository;
        this.mapper = mapper;
    }

    @Override
    public PembelianPakanDetailResponse create(PembelianPakanDetailRequest request) {
        PembelianPakan pembelianPakan = pembelianPakanRepository.findById(request.getPembelianPakanId())
                .orElseThrow(() -> new ResourceNotFoundException(Constant.PEMBELIAN_PAKAN, request.getPembelianPakanId()));
        JenisPakan jenisPakan = jenisPakanRepository.findById(request.getJenisPakanId())
                .orElseThrow(() -> new ResourceNotFoundException(Constant.JENIS_PAKAN, request.getJenisPakanId()));
        PembelianPakanDetail entity = mapper.toEntity(request);
        entity.setPembelianPakan(pembelianPakan);
        entity.setJenisPakan(jenisPakan);
        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public PembelianPakanDetailResponse update(Long id, PembelianPakanDetailRequest request) {
        PembelianPakanDetail entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.PEMBELIAN_PAKAN_DETAIL, id));
        mapper.updateEntityFromRequest(request, entity);
        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public List<PembelianPakanDetailResponse> findAll() {
        List<PembelianPakanDetail> lsEntity = repository.findAll();
        return mapper.toResponse(lsEntity);
    }

    @Override
    public PembelianPakanDetailResponse findById(Long id) {
        PembelianPakanDetail entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.PEMBELIAN_PAKAN_DETAIL, id));
        return mapper.toResponse(entity);
    }

    @Override
    public void delete(Long id) {
        repository.delete(repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.PEMBELIAN_PAKAN_DETAIL, id)));
    }
}
