package com.hindustries.service.domain.operasional.flock;

import com.hindustries.base.BaseServiceImpl;
import com.hindustries.dto.request.domain.operasional.flock.KelompokAyamRequest;
import com.hindustries.dto.response.domain.operasional.flock.KelompokAyamResponse;
import com.hindustries.dto.response.domain.operasional.flock.KelompokAyamRingkasanResponse;
import com.hindustries.entity.domain.operasional.flock.KelompokAyam;
import com.hindustries.entity.domain.operasional.flock.StatusKelompok;
import com.hindustries.entity.domain.master.Kandang;
import com.hindustries.entity.domain.master.RasAyam;
import com.hindustries.mapper.domain.operasional.flock.KelompokAyamMapper;
import com.hindustries.repository.domain.operasional.flock.KelompokAyamRepository;
import com.hindustries.repository.domain.master.KandangRepository;
import com.hindustries.repository.domain.master.RasAyamRepository;
import com.hindustries.util.Constant;
import com.hindustries.util.ResourceNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Service
@Transactional
public class KelompokAyamService extends BaseServiceImpl<KelompokAyam, KelompokAyamRequest, KelompokAyamResponse, Long> {

    private final KelompokAyamRepository repository;
    private final KandangRepository kandangRepository;
    private final RasAyamRepository rasAyamRepository;
    private final KelompokAyamMapper mapper;

    public KelompokAyamService(KelompokAyamRepository repository, KelompokAyamMapper mapper, KandangRepository kandangRepository, RasAyamRepository rasAyamRepository) {
        super(KelompokAyam.class);
        this.repository = repository;
        this.kandangRepository = kandangRepository;
        this.rasAyamRepository = rasAyamRepository;
        this.mapper = mapper;
    }

    @Override
    protected JpaRepository<KelompokAyam, Long> getRepository() {
        return repository;
    }

    @Override
    protected KelompokAyamResponse mapToResponse(KelompokAyam kelompokAyam) {
        return mapper.toResponse(kelompokAyam);
    }

    @Override
    protected KelompokAyam mapToEntity(KelompokAyamRequest request) {
        return mapper.toEntity(request);
    }

    @Override
    protected void updateEntityFromReq(KelompokAyamRequest request, KelompokAyam entity) {
        mapper.updateEntityFromRequest(request, entity);
    }

    @Override
    protected void beforeCreate(KelompokAyamRequest request, KelompokAyam entity) {
        Kandang kandang = kandangRepository.findById(request.getKandangId())
                .orElseThrow(() -> new ResourceNotFoundException(Constant.KANDANG, request.getKandangId()));
        RasAyam rasAyam = rasAyamRepository.findById(request.getRasId())
                .orElseThrow(() -> new ResourceNotFoundException(Constant.RAS_AYAM, request.getRasId()));
        entity.setKandang(kandang);
        entity.setRas(rasAyam);
    }

    @Override
    protected void beforeUpdate(KelompokAyamRequest request, KelompokAyam entity) {
        Kandang kandang = kandangRepository.findById(request.getKandangId())
                .orElseThrow(() -> new ResourceNotFoundException(Constant.KANDANG, request.getKandangId()));
        RasAyam rasAyam = rasAyamRepository.findById(request.getRasId())
                .orElseThrow(() -> new ResourceNotFoundException(Constant.RAS_AYAM, request.getRasId()));
        entity.setKandang(kandang);
        entity.setRas(rasAyam);
    }

    public KelompokAyamResponse aktivasiKelompok(Long id) {
        KelompokAyam entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.KELOMPOK_AYAM, id));
        entity.setStatusKelompok(StatusKelompok.AKTIF);
        entity.setTanggalMulai(new Date());
        KelompokAyam saved = repository.save(entity);
        return mapper.toResponse(saved);
    }

    public KelompokAyamResponse selesaikanKelompok(Long id) {
        KelompokAyam entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.KELOMPOK_AYAM, id));
        entity.setStatusKelompok(StatusKelompok.SELESAI);
        KelompokAyam saved = repository.save(entity);
        return mapper.toResponse(saved);
    }

    public KelompokAyamRingkasanResponse lihatRingkasanKelompok(Long id) {
        KelompokAyam kelompokAyam = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.KELOMPOK_AYAM, id));
        Integer aktual = repository.findPopulasiAktual(id);
        long umur = ChronoUnit.DAYS.between(kelompokAyam.getTanggalMulai().toInstant().atZone(ZoneId.systemDefault())
                .toLocalDate(), LocalDate.now());
        KelompokAyamRingkasanResponse result = new KelompokAyamRingkasanResponse();
        result.setId(kelompokAyam.getId());
        result.setNamaKelompok(kelompokAyam.getNamaKelompok());
        result.setStatusKelompok(String.valueOf(kelompokAyam.getStatusKelompok() == null ? "NULL" : kelompokAyam.getStatusKelompok()));
        result.setPopulasiAwal(kelompokAyam.getPopulasiAwal());
        result.setPopulasiAktual(aktual);
        result.setUmurHari(umur);
        return result;
    }

}
