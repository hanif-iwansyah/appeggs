package com.hindustries.service.domain.penjualan;

import com.hindustries.base.BaseService;
import com.hindustries.dto.request.commerce.PenjualanTelurRequest;
import com.hindustries.dto.response.commerce.PenjualanTelurResponse;
import com.hindustries.entity.master.Pelanggan;
import com.hindustries.entity.commerce.PenjualanTelur;
import com.hindustries.mapper.commerce.PenjualanTelurMapper;
import com.hindustries.repository.PelangganRepository;
import com.hindustries.repository.PenjualanTelurRepository;
import com.hindustries.util.Constant;
import com.hindustries.util.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PenjualanTelurService implements BaseService<PenjualanTelurRequest, PenjualanTelurResponse, Long> {

    private final PenjualanTelurRepository repository;
    private final PelangganRepository pelangganRepository;
    private final PenjualanTelurMapper mapper;

    public PenjualanTelurService(PenjualanTelurRepository repository, PelangganRepository pelangganRepository, PenjualanTelurMapper mapper) {
        this.repository = repository;
        this.pelangganRepository = pelangganRepository;
        this.mapper = mapper;
    }

    @Override
    public PenjualanTelurResponse create(PenjualanTelurRequest request) {
        Pelanggan pelanggan = pelangganRepository.findById(request.getPelangganId())
                .orElseThrow(() -> new ResourceNotFoundException(Constant.PELANGGAN, request.getPelangganId()));
        PenjualanTelur entity = mapper.toEntity(request);
        entity.setPelanggan(pelanggan);
        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public PenjualanTelurResponse update(Long id, PenjualanTelurRequest request) {
        PenjualanTelur entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.PENJUALAN_TELUR, id));
        mapper.updateEntityFromRequest(request, entity);
        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public List<PenjualanTelurResponse> findAll() {
        List<PenjualanTelur> lsEntity = repository.findAll();
        return mapper.toResponse(lsEntity);
    }

    @Override
    public PenjualanTelurResponse findById(Long id) {
        PenjualanTelur entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.PENJUALAN_TELUR, id));
        return mapper.toResponse(entity);
    }

    @Override
    public void delete(Long id) {
        repository.delete(repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.PENJUALAN_TELUR, id)));
    }
}
