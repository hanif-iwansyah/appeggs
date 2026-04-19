package com.hindustries.service;

import com.hindustries.base.BaseService;
import com.hindustries.dto.request.CatatanVaksinasiRequest;
import com.hindustries.dto.response.CatatanVaksinasiResponse;
import com.hindustries.entity.CatatanVaksinasi;
import com.hindustries.entity.JadwalVaksin;
import com.hindustries.entity.KelompokAyam;
import com.hindustries.mapper.CatatanVaksinasiMapper;
import com.hindustries.repository.CatatanVaksinasiRepository;
import com.hindustries.repository.JadwalVaksinRepository;
import com.hindustries.repository.KelompokAyamRepository;
import com.hindustries.util.Constant;
import com.hindustries.util.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CatatanVaksinasiService implements BaseService<CatatanVaksinasiRequest, CatatanVaksinasiResponse, Long> {

    private final CatatanVaksinasiRepository repository;
    private final JadwalVaksinRepository jadwalVaksinRepository;
    private final KelompokAyamRepository kelompokAyamRepository;
    private final CatatanVaksinasiMapper mapper;

    public CatatanVaksinasiService(CatatanVaksinasiRepository repository, JadwalVaksinRepository jadwalVaksinRepository, KelompokAyamRepository kelompokAyamRepository, CatatanVaksinasiMapper mapper) {
        this.repository = repository;
        this.jadwalVaksinRepository = jadwalVaksinRepository;
        this.kelompokAyamRepository = kelompokAyamRepository;
        this.mapper = mapper;
    }

    @Override
    public CatatanVaksinasiResponse create(CatatanVaksinasiRequest request) {
        JadwalVaksin jadwalVaksin = jadwalVaksinRepository.findById(request.getJadwalVaksinId())
                .orElseThrow(() -> new ResourceNotFoundException(Constant.JADWAL_VAKSIN, request.getJadwalVaksinId()));
        KelompokAyam kelompokAyam = kelompokAyamRepository.findById(request.getKelompokAyamId())
                .orElseThrow(() -> new ResourceNotFoundException(Constant.KELOMPOK_AYAM, request.getKelompokAyamId()));
        CatatanVaksinasi entity = mapper.toEntity(request);
        entity.setJadwalVaksin(jadwalVaksin);
        entity.setKelompokAyam(kelompokAyam);
        return mapper.toResponse(repository.save(mapper.toEntity(request)));
    }

    @Override
    public CatatanVaksinasiResponse update(Long id, CatatanVaksinasiRequest request) {
        JadwalVaksin jadwalVaksin = jadwalVaksinRepository.findById(request.getJadwalVaksinId())
                .orElseThrow(() -> new ResourceNotFoundException(Constant.JADWAL_VAKSIN, request.getJadwalVaksinId()));
        KelompokAyam kelompokAyam = kelompokAyamRepository.findById(request.getKelompokAyamId())
                .orElseThrow(() -> new ResourceNotFoundException(Constant.KELOMPOK_AYAM, request.getKelompokAyamId()));
        CatatanVaksinasi entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.CATATAN_VAKSINASI, id));
        entity.setJadwalVaksin(jadwalVaksin);
        entity.setKelompokAyam(kelompokAyam);
        entity.setTanggalVaksin(request.getTanggalVaksin());
        mapper.updateEntityFromRequest(request, entity);
        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public List<CatatanVaksinasiResponse> findAll() {
        List<CatatanVaksinasi> lsEntity = repository.findAll();
        return mapper.toResponse(lsEntity);
    }

    @Override
    public CatatanVaksinasiResponse findById(Long id) {
        return mapper.toResponse(repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.CATATAN_VAKSINASI, id)));
    }

    @Override
    public void delete(Long id) {
        repository.delete(repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.CATATAN_VAKSINASI, id)));
    }
}
