package com.hindustries.controller.domain.operasional.production;

import com.hindustries.dto.request.domain.operasional.production.ProduksiRequest;
import com.hindustries.dto.response.domain.operasional.production.HdpResponse;
import com.hindustries.dto.response.domain.operasional.production.ProduksiTelurSummaryResponse;
import com.hindustries.dto.response.domain.operasional.production.ProduksiBulananResponse;
import com.hindustries.dto.response.domain.operasional.production.ProduksiHarianResponse;
import com.hindustries.dto.response.domain.operasional.production.ProduksiResponse;
import com.hindustries.service.domain.operasional.production.ProduksiService;
import com.hindustries.util.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;

@RestController
@RequestMapping("/api/produksi")
public class ProduksiController {
    private final ProduksiService service;
    public ProduksiController(ProduksiService service) {
        this.service = service;
    }

    @PostMapping("/input")
    public ResponseEntity<ApiResponse<ProduksiResponse>> catatProduksi(@RequestBody @Valid ProduksiRequest request) {
        return ResponseEntity.ok(ApiResponse.success(service.catatProduksi(request)));
    }

    @GetMapping("/harian")
    public ResponseEntity<ApiResponse<ProduksiHarianResponse>> lihatProduksiHarian(LocalDate localDate) {
        return ResponseEntity.ok(ApiResponse.success(service.lihatProduksiHarian(localDate)));
    }

    @GetMapping("/bulanan")
    public ResponseEntity<ApiResponse<ProduksiBulananResponse>> lihatProduksiBulanan(Integer bulan, Integer tahun) {
        return ResponseEntity.ok(ApiResponse.success(service.lihatProduksiBulanan(bulan, tahun)));
    }

    @GetMapping("/hdp")
    public ResponseEntity<ApiResponse<HdpResponse>> getHdp(
            @RequestParam Long kelompokAyamId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dari,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate sampai) {
        return ResponseEntity.ok(ApiResponse.success(service.hitungHDP(kelompokAyamId, dari, sampai)));
    }

    @GetMapping("/summary")
    public ResponseEntity<ApiResponse<ProduksiTelurSummaryResponse>> lihatSummaryProduksi(
            @RequestParam Long kelompokAyamId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dari,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate sampai) {
        return ResponseEntity.ok(ApiResponse.success(service.getSummary(kelompokAyamId, dari, sampai)));
    }

}
