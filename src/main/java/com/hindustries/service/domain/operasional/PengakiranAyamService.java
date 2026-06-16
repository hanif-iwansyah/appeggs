package com.hindustries.service.domain.operasional;

import com.hindustries.dto.request.commerce.PengakiranAyamRequest;
import com.hindustries.dto.response.farm.PengakiranAyamResponse;
import com.hindustries.dto.response.farm.PengakiranKelompokRingkasanResponse;
import com.hindustries.dto.response.farm.PengakiranRingkasanResponse;
import com.hindustries.entity.farm.KelompokAyam;
import com.hindustries.entity.farm.PengakiranAyam;
import com.hindustries.mapper.farm.PengakiranAyamMapper;
import com.hindustries.repository.KelompokAyamRepository;
import com.hindustries.repository.PengakiranAyamRepository;
import com.hindustries.util.Constant;
import com.hindustries.util.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class PengakiranAyamService {
    private final PengakiranAyamRepository repository;
    private final KelompokAyamRepository kelompokAyamRepository;
    private final PengakiranAyamMapper mapper;

    public PengakiranAyamService(PengakiranAyamRepository repository, KelompokAyamRepository kelompokAyamRepository, PengakiranAyamMapper mapper) {
        this.repository = repository;
        this.kelompokAyamRepository = kelompokAyamRepository;
        this.mapper = mapper;
    }

    public PengakiranAyamResponse catatPengakiranAyam(PengakiranAyamRequest request) {
        KelompokAyam kelompokAyam = kelompokAyamRepository.findById(request.getKelompokAyamId())
                .orElseThrow(() -> new ResourceNotFoundException(Constant.KELOMPOK_AYAM, request.getKelompokAyamId()));
        PengakiranAyam entity = mapper.toEntity(request);
        entity.setKelompokAyam(kelompokAyam);
        repository.save(entity);
        return mapper.toResponse(entity);
    }

    public List<PengakiranAyamResponse> lihatRiwayatPengakiran() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    public List<PengakiranAyamResponse> lihatRiwayatPengakiranKelompok(Long id) {
        return repository.findAllByKelompokAyamId(id)
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Transactional(readOnly = true)
    public PengakiranAyamResponse lihatDetailPengakiran(Long id) {
        PengakiranAyam pengakiranAyam = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.PENGAKIRAN_AYAM, id));
        return mapper.toResponse(pengakiranAyam);
    }

    @Transactional(readOnly = true)
    public PengakiranRingkasanResponse lihatRingkasanPengakiran() {
        PengakiranRingkasanResponse result = new PengakiranRingkasanResponse();
        result.setJumlahTransaksi(repository.count());
        result.setTotalAyamAfkir(repository.totalAyamAfkir());
        return result;
    }

    @Transactional
    public PengakiranKelompokRingkasanResponse lihatRingkasanPengakiranKelompok(Long kelompokId) {
        KelompokAyam kelompokAyam = kelompokAyamRepository.findById(kelompokId)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.KELOMPOK_AYAM, kelompokId));

        Integer totalAfkir = repository.totalAfkirByKelompok(kelompokId);
        PengakiranKelompokRingkasanResponse result = new PengakiranKelompokRingkasanResponse();
        result.setKelompokAyamId(kelompokAyam.getId());
        result.setNamaKelompok(kelompokAyam.getNamaKelompok());
        result.setPopulasiAwal(kelompokAyam.getPopulasiAwal());
        result.setTotalAfkir(totalAfkir);

        if (kelompokAyam.getPopulasiAwal() > 0) {
            double persentase = ((double) totalAfkir / kelompokAyam.getPopulasiAwal()) * 100;
            result.setPersentaseAfkir(
                    Math.round(persentase * 100.0) / 100.0 );
        }
        return result;
    }

}
