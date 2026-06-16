package com.hindustries.service.domain.operasional.inventory;

import com.hindustries.base.BaseService;
import com.hindustries.dto.request.domain.operasional.inventory.StokTelurRequest;
import com.hindustries.dto.response.domain.operasional.inventory.StokTelurResponse;
import com.hindustries.entity.domain.master.Gudang;
import com.hindustries.entity.domain.operasional.inventory.StokTelur;
import com.hindustries.mapper.domain.operasional.inventory.StokTelurMapper;
import com.hindustries.repository.domain.master.GudangRepository;
import com.hindustries.repository.domain.operasional.inventory.StokTelurRepository;
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
