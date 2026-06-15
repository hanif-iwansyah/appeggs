package com.hindustries.service.domain.operasional;

import com.hindustries.dto.request.farm.ProduksiRequest;
import com.hindustries.dto.response.farm.ProduksiBulananResponse;
import com.hindustries.dto.response.farm.ProduksiHarianResponse;
import com.hindustries.dto.response.farm.ProduksiResponse;
import com.hindustries.entity.farm.GradingTelur;
import com.hindustries.entity.farm.KelompokAyam;
import com.hindustries.entity.farm.ProduksiTelur;
import com.hindustries.entity.system.LaporanHarian;
import com.hindustries.repository.farm.GradingTelurRepository;
import com.hindustries.repository.farm.KelompokAyamRepository;
import com.hindustries.repository.farm.ProduksiTelurRepository;
import com.hindustries.repository.system.LaporanHarianRepository;
import com.hindustries.util.Constant;
import com.hindustries.util.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;

@Service
@Transactional
public class ProduksiService {
    private final ProduksiTelurRepository produksiRepository;
    private final GradingTelurRepository gradingRepository;
    private final LaporanHarianRepository laporanRepository;
    private final KelompokAyamRepository kelompokAyamRepository;

    public ProduksiService(ProduksiTelurRepository produksiRepository, GradingTelurRepository gradingRepository, LaporanHarianRepository laporanRepository, KelompokAyamRepository kelompokAyamRepository) {
        this.produksiRepository = produksiRepository;
        this.gradingRepository = gradingRepository;
        this.laporanRepository = laporanRepository;
        this.kelompokAyamRepository = kelompokAyamRepository;
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

}
