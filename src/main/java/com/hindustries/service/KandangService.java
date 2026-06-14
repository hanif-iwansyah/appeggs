package com.hindustries.service;

import com.hindustries.base.BaseService;
import com.hindustries.dto.request.KandangRequest;
import com.hindustries.dto.response.KandangResponse;
import com.hindustries.entity.master.Kandang;
import com.hindustries.entity.master.Peternakan;
import com.hindustries.mapper.KandangMapper;
import com.hindustries.mapper.PeternakanMapper;
import com.hindustries.repository.KandangRepository;
import com.hindustries.repository.PeternakanRepository;
import com.hindustries.util.Constant;
import com.hindustries.util.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class KandangService implements BaseService<KandangRequest, KandangResponse, Long> {

    private final KandangRepository kandangRepository;
    private final PeternakanRepository peternakanRepository;
    private final KandangMapper kandangMapper;
    private final PeternakanMapper peternakanMapper;

    public KandangService(KandangRepository kandangRepository, PeternakanRepository peternakanRepository, KandangMapper kandangMapper, PeternakanMapper peternakanMapper) {
        this.kandangRepository = kandangRepository;
        this.peternakanRepository = peternakanRepository;
        this.kandangMapper = kandangMapper;
        this.peternakanMapper = peternakanMapper;
    }

    @Override
    public KandangResponse create(KandangRequest request) {
        Peternakan peternakan = peternakanRepository.findById(request.getPeternakanId())
                .orElseThrow(() -> new ResourceNotFoundException(Constant.PETERNAKAN, request.getPeternakanId()));
        Kandang entity = kandangMapper.toEntity(request);
        entity.setPeternakan(peternakan);
        Kandang saved = kandangRepository.save(entity);
        return kandangMapper.toResponse(saved);
    }

    @Override
    public KandangResponse update(Long id, KandangRequest request) {
        Kandang entity = kandangRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.KANDANG, id));
        Peternakan peternakan = peternakanRepository.findById(request.getPeternakanId())
                .orElseThrow(() -> new ResourceNotFoundException(Constant.PETERNAKAN, id));
        entity.setNamaKandang(request.getNamaKandang());
        entity.setKapasitas(request.getKapasitas());
        entity.setKontrolSuhu(request.getKontrolSuhu());
        entity.setDibuatPada(Timestamp.from(new Date().toInstant()));
        entity.setPeternakan(peternakan);
        Kandang saved = kandangRepository.save(entity);
        return kandangMapper.toResponse(saved);
    }

    @Override
    public List<KandangResponse> findAll() {
        List<Kandang> lsEntity = kandangRepository.findAll();
        return kandangMapper.toResponse(lsEntity);
    }

    @Override
    public KandangResponse findById(Long id) {
        Kandang entity = kandangRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.KANDANG, id));
        return kandangMapper.toResponse(entity);
    }

    @Override
    public void delete(Long id) {
        if (kandangRepository.existsById(id)) kandangRepository.deleteById(id);
        else throw new ResourceNotFoundException(Constant.KANDANG, id);
    }

}