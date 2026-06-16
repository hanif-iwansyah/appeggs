package com.hindustries.service.domain.operasional.inventory;

import com.hindustries.base.BaseService;
import com.hindustries.dto.request.domain.operasional.inventory.StokPakanRequest;
import com.hindustries.dto.response.domain.operasional.inventory.StokPakanResponse;
import com.hindustries.entity.domain.master.Gudang;
import com.hindustries.entity.domain.master.JenisPakan;
import com.hindustries.entity.domain.operasional.inventory.StokPakan;
import com.hindustries.mapper.domain.operasional.inventory.StokPakanMapper;
import com.hindustries.repository.domain.master.GudangRepository;
import com.hindustries.repository.domain.master.JenisPakanRepository;
import com.hindustries.repository.domain.operasional.inventory.StokPakanRepository;
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


    public StokPakanService(
            StokPakanRepository stokPakanRepository,
            GudangRepository gudangRepository,
            JenisPakanRepository jenisPakanRepository,
            StokPakanMapper stokPakanMapper
    ) {
        this.stokPakanRepository = stokPakanRepository;
        this.gudangRepository = gudangRepository;
        this.jenisPakanRepository = jenisPakanRepository;
        this.stokPakanMapper = stokPakanMapper;
    }

    @Override
    public StokPakanResponse create(StokPakanRequest request) {
        Gudang gudang = gudangRepository.findById(request.getGudangId())
                .orElseThrow(() -> new ResourceNotFoundException(Constant.GUDANG, request.getGudangId()));
        JenisPakan jenisPakan = jenisPakanRepository.findById(request.getJenisPakanId())
                .orElseThrow(() -> new ResourceNotFoundException(Constant.JENIS_PAKAN, request.getJenisPakanId()));
        StokPakan entity = stokPakanMapper.toEntity(request);
        entity.setGudang(gudang);
        entity.setJenisPakan(jenisPakan);
        StokPakan saved = stokPakanRepository.save(entity);
        return stokPakanMapper.toResponse(saved);
    }

    @Override
    public StokPakanResponse update(Long id, StokPakanRequest request) {
        StokPakan entity = stokPakanRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.STOK_PAKAN, id));
        Gudang gudang = gudangRepository.findById(request.getGudangId())
                .orElseThrow(() -> new ResourceNotFoundException(Constant.GUDANG, request.getGudangId()));
        JenisPakan jenisPakan = jenisPakanRepository.findById(request.getJenisPakanId())
                .orElseThrow(() -> new ResourceNotFoundException(Constant.JENIS_PAKAN, request.getJenisPakanId()));
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
        StokPakan entity = stokPakanRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.STOK_PAKAN, id));
        return stokPakanMapper.toResponse(entity);
    }

    @Override
    public void delete(Long id) {
        if (stokPakanRepository.existsById(id)) stokPakanRepository.deleteById(id);
        else throw new ResourceNotFoundException(Constant.STOK_PAKAN, id);
    }
}
