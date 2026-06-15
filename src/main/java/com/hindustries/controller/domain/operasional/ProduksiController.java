package com.hindustries.controller.domain.operasional;

import com.hindustries.dto.request.farm.ProduksiRequest;
import com.hindustries.dto.response.farm.ProduksiBulananResponse;
import com.hindustries.dto.response.farm.ProduksiHarianResponse;
import com.hindustries.dto.response.farm.ProduksiResponse;
import com.hindustries.service.domain.operasional.ProduksiService;
import com.hindustries.util.ApiResponse;
import jakarta.validation.Valid;
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
}
