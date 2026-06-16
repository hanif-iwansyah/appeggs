package com.hindustries.service.domain.pembelian;

import com.hindustries.base.BaseService;
import com.hindustries.dto.request.commerce.PembayaranRequest;
import com.hindustries.dto.response.commerce.PembayaranResponse;
import com.hindustries.entity.commerce.Pembayaran;
import com.hindustries.entity.commerce.PesananPenjualan;
import com.hindustries.mapper.commerce.PembayaranMapper;
import com.hindustries.repository.PembayaranRepository;
import com.hindustries.repository.PesananPenjualanRepository;
import com.hindustries.util.Constant;
import com.hindustries.util.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PembayaranService implements BaseService<PembayaranRequest, PembayaranResponse, Long> {

    private final PembayaranRepository repository;
    private final PesananPenjualanRepository pesananPenjualanRepository;
    private final PembayaranMapper mapper;

    public PembayaranService(PembayaranRepository repository, PesananPenjualanRepository pesananPenjualanRepository, PembayaranMapper mapper) {
        this.repository = repository;
        this.pesananPenjualanRepository = pesananPenjualanRepository;
        this.mapper = mapper;
    }

    @Override
    public PembayaranResponse create(PembayaranRequest request) {
        PesananPenjualan pesananPenjualan = pesananPenjualanRepository.findById(request.getPesananPenjualanId())
                .orElseThrow(() -> new ResourceNotFoundException(Constant.PESANAN_PENJUALAN, request.getPesananPenjualanId()));
        Pembayaran entity = mapper.toEntity(request);
        entity.setPesananPenjualan(pesananPenjualan);
        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public PembayaranResponse update(Long id, PembayaranRequest request) {
        Pembayaran entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.PEMBAYARAN, id));
        mapper.updateEntityFromRequest(request, entity);
        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public List<PembayaranResponse> findAll() {
        List<Pembayaran> lsEntity = repository.findAll();
        return mapper.toResponse(lsEntity);
    }

    @Override
    public PembayaranResponse findById(Long id) {
        Pembayaran entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.PEMBAYARAN, id));
        return mapper.toResponse(entity);
    }

    @Override
    public void delete(Long id) {
        repository.delete(repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.PEMBAYARAN, id)));
    }
}
