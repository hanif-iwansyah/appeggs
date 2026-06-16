package com.hindustries.service.inventory;

import com.hindustries.base.BaseService;
import com.hindustries.dto.request.inventory.StokTelurRequest;
import com.hindustries.dto.response.inventory.StokTelurResponse;
import com.hindustries.entity.inventory.Gudang;
import com.hindustries.entity.inventory.StokTelur;
import com.hindustries.mapper.inventory.StokTelurMapper;
import com.hindustries.repository.GudangRepository;
import com.hindustries.repository.StokTelurRepository;
import com.hindustries.util.Constant;
import com.hindustries.util.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StokTelurService implements BaseService<StokTelurRequest, StokTelurResponse, Long> {

    private final StokTelurRepository stokTelurRepository;
    private final GudangRepository gudangRepository;
    private final StokTelurMapper stokTelurMapper;

    public StokTelurService(StokTelurRepository stokTelurRepository, GudangRepository gudangRepository, StokTelurMapper stokTelurMapper) {
        this.stokTelurRepository = stokTelurRepository;
        this.gudangRepository = gudangRepository;
        this.stokTelurMapper = stokTelurMapper;
    }

    @Override
    public StokTelurResponse create(StokTelurRequest request) {
        Gudang gudang = gudangRepository.findById(request.getGudangId())
                .orElseThrow(() -> new ResourceNotFoundException(Constant.GUDANG, request.getGudangId()));
        StokTelur entity = stokTelurMapper.toEntity(request);
        entity.setGudang(gudang);
        return stokTelurMapper.toResponse(stokTelurRepository.save(entity));
    }

    @Override
    public StokTelurResponse update(Long id, StokTelurRequest request) {
        StokTelur entity = stokTelurRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.STOK_TELUR, id));
        Gudang gudang = gudangRepository.findById(request.getGudangId())
                .orElseThrow(() -> new ResourceNotFoundException(Constant.GUDANG, request.getGudangId()));
        entity.setGradeTelur(request.getGradeTelur());
        entity.setJumlah(request.getJumlah());
        entity.setGudang(gudang);
        return stokTelurMapper.toResponse(stokTelurRepository.save(entity));
    }

    @Override
    public List<StokTelurResponse> findAll() {
        List<StokTelur> lsEntity = stokTelurRepository.findAll();
        return stokTelurMapper.toResponse(lsEntity);
    }

    @Override
    public StokTelurResponse findById(Long id) {
        StokTelur entity = stokTelurRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.STOK_TELUR, id));
        return stokTelurMapper.toResponse(entity);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        StokTelur entity = stokTelurRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.STOK_TELUR, id));
        stokTelurRepository.delete(entity);
    }
}
