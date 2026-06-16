package com.hindustries.service.domain.operasional;

import com.hindustries.dto.request.farm.GradingTelurRequest;
import com.hindustries.dto.request.farm.ProduksiRequest;
import com.hindustries.dto.response.domain.operasional.HdpResponse;
import com.hindustries.dto.response.domain.operasional.ProduksiTelurSummaryResponse;
import com.hindustries.dto.response.farm.GradingTelurResponse;
import com.hindustries.dto.response.farm.ProduksiBulananResponse;
import com.hindustries.dto.response.farm.ProduksiHarianResponse;
import com.hindustries.dto.response.farm.ProduksiResponse;
import com.hindustries.entity.farm.GradingTelur;
import com.hindustries.entity.farm.KelompokAyam;
import com.hindustries.entity.farm.ProduksiTelur;
import com.hindustries.entity.inventory.Gudang;
import com.hindustries.entity.inventory.StokTelur;
import com.hindustries.entity.system.LaporanHarian;
import com.hindustries.mapper.farm.GradingTelurMapper;
import com.hindustries.repository.*;
import com.hindustries.util.Constant;
import com.hindustries.util.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

@Service
@Transactional
public class ProduksiService {
    private final ProduksiTelurRepository produksiRepository;
    private final GradingTelurRepository gradingRepository;
    private final LaporanHarianRepository laporanRepository;
    private final KelompokAyamRepository kelompokAyamRepository;
    private final StokTelurRepository stokTelurRepository;
    private final GudangRepository gudangRepository;
    private final GradingTelurMapper gradingTelurMapper;

    public ProduksiService(ProduksiTelurRepository produksiRepository, GradingTelurRepository gradingRepository, LaporanHarianRepository laporanRepository, KelompokAyamRepository kelompokAyamRepository, StokTelurRepository stokTelurRepository, GudangRepository gudangRepository, GradingTelurMapper gradingTelurMapper) {
        this.produksiRepository = produksiRepository;
        this.gradingRepository = gradingRepository;
        this.laporanRepository = laporanRepository;
        this.kelompokAyamRepository = kelompokAyamRepository;
        this.stokTelurRepository = stokTelurRepository;
        this.gudangRepository = gudangRepository;
        this.gradingTelurMapper = gradingTelurMapper;
    }

    public ProduksiResponse catatProduksi(ProduksiRequest request) {
        KelompokAyam kelompokAyam = kelompokAyamRepository.findById(request.getKelompokAyamId())
                .orElseThrow(() -> new ResourceNotFoundException(Constant.KELOMPOK_AYAM, request.getKelompokAyamId()));

        ProduksiTelur produksi = new ProduksiTelur();
        produksi.setKelompokAyam(kelompokAyam);
        produksi.setTanggalProduksi(request.getTanggal());
        produksi.setTelurAbnormal( request.getTelurRetak() + request.getTelurKecil() );
        produksi.setTotalTelur(request.getJumlahTelur());
        ProduksiTelur produksiSaved = produksiRepository.save(produksi);

        GradingTelur grading = new GradingTelur();
        grading.setProduksiTelur(produksiSaved);
        grading.setGradeA(request.getTelurBaik());
        grading.setGradeB(request.getTelurRetak());
        grading.setGradeC(request.getTelurKecil());
        gradingRepository.save(grading);

        LaporanHarian laporanHarian = new LaporanHarian();
        laporanHarian.setPeternakan(kelompokAyam.getKandang().getPeternakan());
        laporanHarian.setTanggalLaporan(request.getTanggal());
        laporanHarian.setTotalTelur(request.getJumlahTelur());
        laporanHarian.setTotalKematian(request.getTotalKematian());
        laporanRepository.save(laporanHarian);

        ProduksiResponse response = new ProduksiResponse();
        response.setKelompokAyamId(kelompokAyam.getId());
        response.setNamaKelompok(kelompokAyam.getNamaKelompok());
        response.setTanggal(request.getTanggal());
        response.setJumlahTelur(request.getJumlahTelur());
        response.setTelurBaik(request.getTelurBaik());
        response.setTelurRetak(request.getTelurRetak());
        response.setTelurKecil(request.getTelurKecil());
        return response;
    }

    @Transactional(readOnly = true)
    public ProduksiHarianResponse lihatProduksiHarian(LocalDate tanggal) {
        ProduksiHarianResponse response = new ProduksiHarianResponse();
        response.setTanggal(tanggal);
        response.setTotalProduksi(produksiRepository.totalProduksiHarian(tanggal));
        response.setTelurBaik(response.getTelurBaik());
        response.setTelurRetak(response.getTelurRetak());
        response.setTelurKecil(response.getTelurKecil());
        return response;
    }

    @Transactional(readOnly = true)
    public ProduksiBulananResponse lihatProduksiBulanan(Integer bulan, Integer tahun) {
        Integer total = produksiRepository.totalProduksiBulanan(bulan, tahun);
        ProduksiBulananResponse response = new ProduksiBulananResponse();
        response.setBulan(bulan);
        response.setTahun(tahun);
        response.setTotalProduksi(total);
        response.setRataRataProduksi( total / 30.0 );
        return response;
    }

    public HdpResponse hitungHDP(Long kelompokAyamId, LocalDate dari, LocalDate sampai) {
        KelompokAyam kelompokAyam = kelompokAyamRepository.findById(kelompokAyamId).orElseThrow(() -> new ResourceNotFoundException(Constant.KELOMPOK_AYAM, kelompokAyamId));
        Integer totalTelur = produksiRepository.sumTelurValid(kelompokAyamId, dari, sampai);
        Integer populasi = kelompokAyamRepository.findPopulasiAktual(kelompokAyamId);
        long hari = ChronoUnit.DAYS.between(dari, sampai) + 1;
        BigDecimal hdp = BigDecimal.ZERO;
        if (populasi != null && populasi > 0) {
            hdp = BigDecimal.valueOf(totalTelur)
                    .divide(BigDecimal.valueOf((long) populasi * hari), 4, RoundingMode.HALF_UP)
                    .multiply(BigDecimal.valueOf(100));
        }
        HdpResponse hdpResponse = new HdpResponse();
        hdpResponse.setNamaKelompok(kelompokAyam.getNamaKelompok());
        hdpResponse.setDari(dari);
        hdpResponse.setSampai(sampai);
        hdpResponse.setPopulasiAktual(kelompokAyam.getPopulasiAwal());
        hdpResponse.setHdpPersen(hdp);
        hdpResponse.setTotalTelurValid(totalTelur);

        return hdpResponse;
    }

    @Transactional
    public GradingTelurResponse createGradingTelur(GradingTelurRequest request) {
        ProduksiTelur produksi = produksiRepository.findById(request.getProduksiTelurId())
                .orElseThrow(() -> new ResourceNotFoundException(Constant.PRODUKSI_TELUR, request.getProduksiTelurId()));
        // Validate: sum of grades must not exceed valid eggs
        int validTelur = produksi.getTotalTelur() - produksi.getTelurPecah() - produksi.getTelurAbnormal();

        if (request.getGradeA() + request.getGradeB() + request.getGradeC() > validTelur) {
            throw new IllegalArgumentException("Total grading melebihi jumlah telur valid: " + validTelur);
        }

        // Save grading record
        GradingTelur entity = gradingTelurMapper.toEntity(request);
        entity.setProduksiTelur(produksi);
        GradingTelur saved = gradingRepository.save(entity);

        // Auto-update StokTelur per grade
        updateStok("A", request.getGradeA(), request.getGudangId());
        updateStok("B", request.getGradeB(), request.getGudangId());
        updateStok("C", request.getGradeC(), request.getGudangId());

        return gradingTelurMapper.toResponse(saved);
    }

    private void updateStok(String grade, int jumlah, Long gudangId) {
        if (jumlah <= 0) return;
        Optional<StokTelur> existing = stokTelurRepository.findByGradeTelurAndGudang_Id(grade, gudangId);
        if (existing.isPresent()) {
            existing.get().setJumlah(existing.get().getJumlah() + jumlah);
            stokTelurRepository.save(existing.get());
        } else {
            Gudang gudang = gudangRepository.findById(gudangId)
                    .orElseThrow(() -> new ResourceNotFoundException(Constant.GUDANG, gudangId));
            StokTelur baru = new StokTelur();
            baru.setGradeTelur(grade);
            baru.setJumlah(jumlah);
            baru.setGudang(gudang);
            stokTelurRepository.save(baru);
        }
    }

    @Transactional(readOnly = true)
    public ProduksiTelurSummaryResponse getSummary(
            Long kelompokAyamId,
            LocalDate dari,
            LocalDate sampai) {
        kelompokAyamRepository.findById(kelompokAyamId)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.KELOMPOK_AYAM, kelompokAyamId));

        ProduksiTelurSummaryResponse summary = produksiRepository.getSummary(kelompokAyamId, dari, sampai);
        if (summary == null) {
            summary = new ProduksiTelurSummaryResponse(kelompokAyamId, null, 0L, 0L, 0L, 0L);
        }
        return summary;
    }


}
