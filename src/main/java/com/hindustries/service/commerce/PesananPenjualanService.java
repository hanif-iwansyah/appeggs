package com.hindustries.service.commerce;

import com.hindustries.base.BaseService;
import com.hindustries.dto.request.commerce.PesananPenjualanRequest;
import com.hindustries.dto.response.commerce.PesananPenjualanResponse;
import com.hindustries.entity.master.Pelanggan;
import com.hindustries.entity.commerce.PesananPenjualan;
import com.hindustries.mapper.commerce.PesananPenjualanMapper;
import com.hindustries.repository.master.PelangganRepository;
import com.hindustries.repository.commerce.PesananPenjualanRepository;
import com.hindustries.util.Constant;
import com.hindustries.util.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PesananPenjualanService implements BaseService<PesananPenjualanRequest, PesananPenjualanResponse, Long> {

    private final PesananPenjualanRepository repository;
    private final PelangganRepository pelangganRepository;
    private final PesananPenjualanMapper mapper;

    public PesananPenjualanService(PesananPenjualanRepository repository, PelangganRepository pelangganRepository, PesananPenjualanMapper mapper) {
        this.repository = repository;
        this.pelangganRepository = pelangganRepository;
        this.mapper = mapper;
    }

    @Override
    public PesananPenjualanResponse create(PesananPenjualanRequest request) {
        Pelanggan pelanggan = pelangganRepository.findById(request.getPelangganId())
                .orElseThrow(() -> new ResourceNotFoundException(Constant.PELANGGAN, request.getPelangganId()));
        PesananPenjualan entity = mapper.toEntity(request);
        entity.setPelanggan(pelanggan);
        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public PesananPenjualanResponse update(Long id, PesananPenjualanRequest request) {
        PesananPenjualan entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.PESANAN_PENJUALAN, id));
        mapper.updateEntityFromRequest(request, entity);
        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public List<PesananPenjualanResponse> findAll() {
        List<PesananPenjualan> lsEntity = repository.findAll();
        return mapper.toResponse(lsEntity);
    }

    @Override
    public PesananPenjualanResponse findById(Long id) {
        PesananPenjualan entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.PESANAN_PENJUALAN, id));
        return mapper.toResponse(entity);
    }

    @Override
    public void delete(Long id) {
        repository.delete(repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.PESANAN_PENJUALAN, id)));
    }
}
