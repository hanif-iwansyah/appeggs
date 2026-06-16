package com.hindustries.service.farm;

import com.hindustries.base.BaseService;
import com.hindustries.dto.request.farm.ProduksiTelurRequest;
import com.hindustries.dto.response.farm.ProduksiTelurResponse;
import com.hindustries.entity.farm.KelompokAyam;
import com.hindustries.entity.farm.ProduksiTelur;
import com.hindustries.mapper.farm.ProduksiTelurMapper;
import com.hindustries.repository.KelompokAyamRepository;
import com.hindustries.repository.ProduksiTelurRepository;
import com.hindustries.util.Constant;
import com.hindustries.util.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProduksiTelurService implements BaseService<ProduksiTelurRequest, ProduksiTelurResponse, Long> {

    private final ProduksiTelurRepository repository;
    private final KelompokAyamRepository kelompokAyamRepository;
    private final ProduksiTelurMapper mapper;

    public ProduksiTelurService(ProduksiTelurRepository repository, KelompokAyamRepository kelompokAyamRepository, ProduksiTelurMapper mapper) {
        this.repository = repository;
        this.kelompokAyamRepository = kelompokAyamRepository;
        this.mapper = mapper;
    }

    @Override
    public ProduksiTelurResponse create(ProduksiTelurRequest request) {
        KelompokAyam kelompokAyam = kelompokAyamRepository.findById(request.getKelompokAyamId())
                .orElseThrow(() -> new ResourceNotFoundException(Constant.KELOMPOK_AYAM, request.getKelompokAyamId()));
        ProduksiTelur entity = mapper.toEntity(request);
        entity.setKelompokAyam(kelompokAyam);
        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public ProduksiTelurResponse update(Long id, ProduksiTelurRequest request) {
        KelompokAyam kelompokAyam = kelompokAyamRepository.findById(request.getKelompokAyamId())
                .orElseThrow(() -> new ResourceNotFoundException(Constant.KELOMPOK_AYAM, request.getKelompokAyamId()));
        ProduksiTelur entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.PRODUKSI_TELUR, id));
        entity.setKelompokAyam(kelompokAyam);
        entity.setTanggalProduksi(request.getTanggalProduksi());
        entity.setTotalTelur(request.getTotalTelur());
        entity.setTelurPecah(request.getTelurPecah());
        entity.setTelurAbnormal(request.getTelurAbnormal());
        mapper.updateEntityFromRequest(request, entity);
        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public List<ProduksiTelurResponse> findAll() {
        List<ProduksiTelur> lsEntity = repository.findAll();
        return mapper.toResponse(lsEntity);
    }

    @Override
    public ProduksiTelurResponse findById(Long id) {
        return mapper.toResponse(repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.PRODUKSI_TELUR, id)));
    }

    @Override
    public void delete(Long id) {
        repository.delete(repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.PRODUKSI_TELUR, id)));

    }
}
