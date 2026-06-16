package com.hindustries.service.domain.penjualan;

import com.hindustries.base.BaseService;
import com.hindustries.dto.request.domain.penjualan.PengirimanRequest;
import com.hindustries.dto.response.domain.penjualan.PengirimanResponse;
import com.hindustries.entity.domain.penjualan.Pengiriman;
import com.hindustries.entity.domain.penjualan.PesananPenjualan;
import com.hindustries.mapper.domain.penjualan.PengirimanMapper;
import com.hindustries.repository.domain.penjualan.PengirimanRepository;
import com.hindustries.repository.domain.penjualan.PesananPenjualanRepository;
import com.hindustries.util.Constant;
import com.hindustries.util.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PengirimanService implements BaseService<PengirimanRequest, PengirimanResponse, Long> {

    private final PengirimanRepository repository;
    private final PesananPenjualanRepository pesananPenjualanRepository;
    private final PengirimanMapper mapper;

    public PengirimanService(PengirimanRepository repository, PesananPenjualanRepository pesananPenjualanRepository, PengirimanMapper mapper) {
        this.repository = repository;
        this.pesananPenjualanRepository = pesananPenjualanRepository;
        this.mapper = mapper;
    }

    @Override
    public PengirimanResponse create(PengirimanRequest request) {
        PesananPenjualan pesananPenjualan = pesananPenjualanRepository.findById(request.getPesananPenjualanId())
                .orElseThrow(() -> new ResourceNotFoundException(Constant.PESANAN_PENJUALAN, request.getPesananPenjualanId()));
        Pengiriman entity = mapper.toEntity(request);
        entity.setPesananPenjualan(pesananPenjualan);
        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public PengirimanResponse update(Long id, PengirimanRequest request) {
        Pengiriman entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.PENGIRIMAN, id));
        mapper.updateEntityFromRequest(request, entity);
        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public List<PengirimanResponse> findAll() {
        List<Pengiriman> lsEntity = repository.findAll();
        return mapper.toResponse(lsEntity);
    }

    @Override
    public PengirimanResponse findById(Long id) {
        Pengiriman entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.PENGIRIMAN, id));
        return mapper.toResponse(entity);
    }

    @Override
    public void delete(Long id) {
        repository.delete(repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.PENGIRIMAN, id)));
    }
}
