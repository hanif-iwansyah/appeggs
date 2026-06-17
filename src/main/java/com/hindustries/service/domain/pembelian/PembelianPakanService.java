package com.hindustries.service.domain.pembelian;

import com.hindustries.dto.response.domain.pembelian.PembelianPakanResponse;
import com.hindustries.entity.domain.master.Gudang;
import com.hindustries.entity.domain.operasional.inventory.StatusPembelianPakan;
import com.hindustries.entity.domain.operasional.inventory.StokPakan;
import com.hindustries.entity.domain.pembelian.PembelianPakan;
import com.hindustries.entity.domain.pembelian.PembelianPakanDetail;
import com.hindustries.mapper.domain.pembelian.PembelianPakanMapper;
import com.hindustries.repository.domain.master.GudangRepository;
import com.hindustries.repository.domain.master.PemasokRepository;
import com.hindustries.repository.domain.operasional.inventory.StokPakanRepository;
import com.hindustries.repository.domain.pembelian.PembelianPakanRepository;
import com.hindustries.util.Constant;
import com.hindustries.util.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
public class PembelianPakanService {

    private final PembelianPakanRepository repository;
    private final PemasokRepository pemasokRepository;
    private final StokPakanRepository stokPakanRepository;
    private final GudangRepository gudangRepository;
    private final PembelianPakanMapper mapper;

    public PembelianPakanService(PembelianPakanRepository repository, PemasokRepository pemasokRepository, StokPakanRepository stokPakanRepository, GudangRepository gudangRepository, PembelianPakanMapper mapper) {
        this.repository = repository;
        this.pemasokRepository = pemasokRepository;
        this.stokPakanRepository = stokPakanRepository;
        this.gudangRepository = gudangRepository;
        this.mapper = mapper;
    }

    @Transactional
    public PembelianPakanResponse terimaBarang(Long pembelianPakanId) {
        PembelianPakan pembelian = repository.findById(pembelianPakanId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        Constant.PEMBELIAN_PAKAN, pembelianPakanId));
        if (pembelian.getStatusPembelian() == StatusPembelianPakan.DITERIMA) {
            throw new IllegalStateException(
                    "Pembelian id=" + pembelianPakanId + " sudah pernah diterima."
            );
        }
        for (PembelianPakanDetail detail : pembelian.getDetails()) {
            Optional<StokPakan> existingStok = stokPakanRepository
                    .findByJenisPakan_IdAndGudang_Id(
                            detail.getJenisPakan().getId(),
                            detail.getGudangTujuanId());
            if (existingStok.isPresent()) {
                existingStok.get().setJumlahKg(
                        existingStok.get().getJumlahKg().add(detail.getJumlahKg()));
                stokPakanRepository.save(existingStok.get());
            } else {
                Gudang gudang = gudangRepository.findById(detail.getGudangTujuanId())
                        .orElseThrow(() -> new ResourceNotFoundException(
                                Constant.GUDANG, detail.getGudangTujuanId()));
                StokPakan stokBaru = new StokPakan();
                stokBaru.setJenisPakan(detail.getJenisPakan());
                stokBaru.setJumlahKg(detail.getJumlahKg());
                stokBaru.setGudang(gudang);
                stokPakanRepository.save(stokBaru);
            }
        }
        pembelian.setStatusPembelian(StatusPembelianPakan.DITERIMA);
        return mapper.toResponse(repository.save(pembelian));
    }


//    @Override
//    public PembelianPakanResponse create(PembelianPakanRequest request) {
//        Pemasok pemasok = pemasokRepository.findById(request.getPemasokId())
//                .orElseThrow(() -> new ResourceNotFoundException(Constant.PEMASOK, request.getPemasokId()));
//        PembelianPakan entity = mapper.toEntity(request);
//        entity.setPemasok(pemasok);
//        return mapper.toResponse(repository.save(entity));
//    }
//
//    @Override
//    public PembelianPakanResponse update(Long id, PembelianPakanRequest request) {
//        PembelianPakan entity = repository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException(Constant.PEMBELIAN_PAKAN, id));
//        mapper.updateEntityFromRequest(request, entity);
//        return mapper.toResponse(repository.save(entity));
//    }
//
//    @Override
//    public List<PembelianPakanResponse> findAll() {
//        List<PembelianPakan> lsEntity = repository.findAll();
//        return mapper.toResponse(lsEntity);
//    }
//
//    @Override
//    public PembelianPakanResponse findById(Long id) {
//        PembelianPakan entity = repository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException(Constant.PEMBELIAN_PAKAN, id));
//        return mapper.toResponse(entity);
//    }
//
//    @Override
//    public void delete(Long id) {
//        repository.delete(repository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException(Constant.PEMBELIAN_PAKAN, id)));
//    }


}
