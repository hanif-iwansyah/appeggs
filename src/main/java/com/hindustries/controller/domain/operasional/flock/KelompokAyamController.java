package com.hindustries.controller.domain.operasional.flock;

import com.hindustries.base.BaseController;
import com.hindustries.base.BaseService;
import com.hindustries.dto.request.domain.operasional.flock.KelompokAyamRequest;
import com.hindustries.dto.response.domain.operasional.flock.KelompokAyamResponse;
import com.hindustries.dto.response.domain.operasional.flock.KelompokAyamRingkasanResponse;
import com.hindustries.service.domain.operasional.flock.KelompokAyamService;
import com.hindustries.util.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/kelompok-ayam")
public class KelompokAyamController extends BaseController<KelompokAyamRequest, KelompokAyamResponse, Long> {
    private final KelompokAyamService service;

    public KelompokAyamController(KelompokAyamService service) {
        this.service = service;
    }

    @Override
    protected BaseService<KelompokAyamRequest, KelompokAyamResponse, Long> getService() {
        return service;
    }

    @PostMapping("/{id}/aktivasi-kelompok")
    public ResponseEntity<ApiResponse<KelompokAyamResponse>> aktivasiKelompok(@PathVariable Long id) {
        return ResponseEntity.ok(ApiResponse.success(service.aktivasiKelompok(id)));
    }

    @PostMapping("/{id}/selesaikan-kelompok")
    public ResponseEntity<ApiResponse<KelompokAyamResponse>> selesaikanKelompok(@PathVariable Long id) {
        return ResponseEntity.ok(ApiResponse.success(service.selesaikanKelompok(id)));
    }

    @GetMapping("/{id}/lihat-ringkasan-kelompok")
    public ResponseEntity<ApiResponse<KelompokAyamRingkasanResponse>> lihatRingkasanKelompok(@PathVariable Long id) {
        return ResponseEntity.ok(ApiResponse.success(service.lihatRingkasanKelompok(id)));
    }


    @GetMapping("/{id}/lihat-riwayat-pengakiran-kelompok")
    public ResponseEntity<ApiResponse<KelompokAyamRingkasanResponse>> lihatRiwayatPengakiranKelompok(@PathVariable Long id) {
        return ResponseEntity.ok(ApiResponse.success(service.lihatRingkasanKelompok(id)));
    }
}
