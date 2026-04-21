package com.hindustries.service;

import com.hindustries.base.BaseService;
import com.hindustries.dto.request.KonsumsiPakanRequest;
import com.hindustries.dto.response.KonsumsiPakanResponse;
import com.hindustries.entity.JenisPakan;
import com.hindustries.entity.KelompokAyam;
import com.hindustries.entity.KematianAyam;
import com.hindustries.entity.KonsumsiPakan;
import com.hindustries.mapper.KonsumsiPakanMapper;
import com.hindustries.repository.JenisPakanRepository;
import com.hindustries.repository.KelompokAyamRepository;
import com.hindustries.repository.KonsumsiPakanRepository;
import com.hindustries.util.Constant;
import com.hindustries.util.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class KonsumsiPakanService implements BaseService<KonsumsiPakanRequest, KonsumsiPakanResponse, Long> {

    private final KonsumsiPakanRepository repository;
    private final KelompokAyamRepository kelompokAyamRepository;
    private final JenisPakanRepository jenisPakanRepository;
    private final KonsumsiPakanMapper mapper;

    public KonsumsiPakanService(KonsumsiPakanRepository repository, KelompokAyamRepository kelompokAyamRepository, JenisPakanRepository jenisPakanRepository, KonsumsiPakanMapper mapper) {
        this.repository = repository;
        this.kelompokAyamRepository = kelompokAyamRepository;
        this.jenisPakanRepository = jenisPakanRepository;
        this.mapper = mapper;
    }

    @Override
    public KonsumsiPakanResponse create(KonsumsiPakanRequest request) {
        KelompokAyam kelompokAyam = kelompokAyamRepository.findById(request.getKelompokAyamId())
                .orElseThrow(() -> new ResourceNotFoundException(Constant.KELOMPOK_AYAM, request.getKelompokAyamId()));
        JenisPakan jenisPakan = jenisPakanRepository.findById(request.getJenisPakanId())
                .orElseThrow(() -> new ResourceNotFoundException(Constant.JENIS_PAKAN, request.getJenisPakanId()));
        KonsumsiPakan entity = mapper.toEntity(request);
        entity.setKelompokAyam(kelompokAyam);
        entity.setJenisPakan(jenisPakan);
        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public KonsumsiPakanResponse update(Long id, KonsumsiPakanRequest request) {
        KelompokAyam kelompokAyam = kelompokAyamRepository.findById(request.getKelompokAyamId())
                .orElseThrow(() -> new ResourceNotFoundException(Constant.KELOMPOK_AYAM, request.getKelompokAyamId()));
        JenisPakan jenisPakan = jenisPakanRepository.findById(request.getJenisPakanId())
                .orElseThrow(() -> new ResourceNotFoundException(Constant.JENIS_PAKAN, request.getJenisPakanId()));
        KonsumsiPakan entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.KONSUMSI_PAKAN, id));
        mapper.updateEntityFromRequest(request, entity);
        entity.setKelompokAyam(kelompokAyam);
        entity.setJenisPakan(jenisPakan);
        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public List<KonsumsiPakanResponse> findAll() {
        List<KonsumsiPakan> lsEntity = repository.findAll();
        return mapper.toResponse(lsEntity);
    }

    @Override
    public KonsumsiPakanResponse findById(Long id) {
        KonsumsiPakan entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.KONSUMSI_PAKAN, id));
        return mapper.toResponse(entity);
    }

    @Override
    public void delete(Long id) {
        repository.delete(repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.KONSUMSI_PAKAN, id)));
    }
}
