package com.hindustries.service;

import com.hindustries.base.BaseService;
import com.hindustries.dto.request.StokPakanRequest;
import com.hindustries.dto.response.StokPakanResponse;
import com.hindustries.entity.Gudang;
import com.hindustries.entity.JenisPakan;
import com.hindustries.entity.StokPakan;
import com.hindustries.mapper.GudangMapper;
import com.hindustries.mapper.JenisPakanMapper;
import com.hindustries.mapper.StokPakanMapper;
import com.hindustries.repository.GudangRepository;
import com.hindustries.repository.JenisPakanRepository;
import com.hindustries.repository.StokPakanRepository;
import com.hindustries.util.Constant;
import com.hindustries.util.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StokPakanService implements BaseService<StokPakanRequest, StokPakanResponse, Long> {

    private final StokPakanRepository stokPakanRepository;
    private final GudangRepository gudangRepository;
    private final JenisPakanRepository jenisPakanRepository;
    private final StokPakanMapper stokPakanMapper;


    public StokPakanService(StokPakanRepository stokPakanRepository, GudangRepository gudangRepository, JenisPakanRepository jenisPakanRepository, StokPakanMapper stokPakanMapper, GudangMapper gudangMapper, JenisPakanMapper jenisPakanMapper) {
        this.stokPakanRepository = stokPakanRepository;
        this.gudangRepository = gudangRepository;
        this.jenisPakanRepository = jenisPakanRepository;
        this.stokPakanMapper = stokPakanMapper;
    }

    @Override
    public StokPakanResponse create(StokPakanRequest request) {
        Gudang gudang = gudangRepository.findById(request.getGudangId()).orElseThrow(() -> new ResourceNotFoundException("Nama gudang", request.getGudangId()));
        JenisPakan jenisPakan = jenisPakanRepository.findById(request.getJenisPakanId()).orElseThrow(() -> new ResourceNotFoundException("Nama pakan", request.getJenisPakanId()));
        StokPakan entity = stokPakanMapper.toEntity(request);
        entity.setGudang(gudang);
        entity.setJenisPakan(jenisPakan);
        StokPakan saved = stokPakanRepository.save(entity);
        return stokPakanMapper.toResponse(saved);
    }

    @Override
    public StokPakanResponse update(Long id, StokPakanRequest request) {
        StokPakan entity = stokPakanRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Constant.STOK_PAKAN, id));
        Gudang gudang = gudangRepository.findById(request.getGudangId()).orElseThrow(() -> new ResourceNotFoundException(Constant.GUDANG, request.getGudangId()));
        JenisPakan jenisPakan = jenisPakanRepository.findById(request.getJenisPakanId()).orElseThrow(() -> new ResourceNotFoundException(Constant.JENIS_PAKAN, request.getJenisPakanId()));
        entity.setJumlahKg(request.getJumlahKg());
        entity.setJenisPakan(jenisPakan);
        entity.setGudang(gudang);
        return stokPakanMapper.toResponse(stokPakanRepository.save(entity));
    }

    @Override
    public List<StokPakanResponse> findAll() {
        List<StokPakan> lsEntity = stokPakanRepository.findAll();
        return stokPakanMapper.toResponse(lsEntity);
    }

    @Override
    public StokPakanResponse findById(Long id) {
        StokPakan entity = stokPakanRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Stok pakan", id));
        return stokPakanMapper.toResponse(entity);
    }

    @Override
    public void delete(Long id) {
        if (stokPakanRepository.existsById(id)) stokPakanRepository.deleteById(id);
        else throw new ResourceNotFoundException("Stok pakan", id);
    }
}
