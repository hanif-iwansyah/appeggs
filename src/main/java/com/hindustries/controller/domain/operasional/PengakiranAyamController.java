package com.hindustries.controller.domain.operasional;

import com.hindustries.dto.request.commerce.PengakiranAyamRequest;
import com.hindustries.dto.response.farm.PengakiranAyamResponse;
import com.hindustries.dto.response.farm.PengakiranKelompokRingkasanResponse;
import com.hindustries.dto.response.farm.PengakiranRingkasanResponse;
import com.hindustries.service.domain.operasional.PengakiranAyamService;
import com.hindustries.util.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/pengakiran-ayam")
public class PengakiranAyamController {
    private final PengakiranAyamService service;

    public PengakiranAyamController(PengakiranAyamService service) {
        this.service = service;
    }

    @PostMapping("/input-pengakiran")
    public ResponseEntity<ApiResponse<PengakiranAyamResponse>> catatPengakiranAyam(@RequestBody @Valid PengakiranAyamRequest request) {
        return ResponseEntity.ok(ApiResponse.success(service.catatPengakiranAyam(request)));
    }

    @GetMapping("/riwayat-pengakiran")
    public ResponseEntity<ApiResponse<List<PengakiranAyamResponse>>> lihatRiwayatPengakiran() {
        return ResponseEntity.ok(ApiResponse.success(service.lihatRiwayatPengakiran()));
    }

    @GetMapping("/riwayat-pengakiran-kelompok")
    public ResponseEntity<ApiResponse<List<PengakiranAyamResponse>>> lihatRiwayatPengakiranKelompok(Long id) {
        return ResponseEntity.ok(ApiResponse.success(service.lihatRiwayatPengakiranKelompok(id)));
    }

    @GetMapping("/detail-pengakiran/{id}")
    public ResponseEntity<ApiResponse<PengakiranAyamResponse>> lihatDetailPengakiran(Long id) {
        return ResponseEntity.ok(ApiResponse.success(service.lihatDetailPengakiran(id)));
    }

    @GetMapping("/ringkasan-pengakiran")
    public ResponseEntity<ApiResponse<PengakiranRingkasanResponse>> lihatRingkasanPengakiran() {
        return ResponseEntity.ok(ApiResponse.success(service.lihatRingkasanPengakiran()));
    }

    @GetMapping("/ringkasan-pengakiran-kelompok/{id}")
    public ResponseEntity<ApiResponse<PengakiranKelompokRingkasanResponse>> lihatRingkasanPengakiranKelompok(Long id) {
        return ResponseEntity.ok(ApiResponse.success(service.lihatRingkasanPengakiranKelompok(id)));
    }

}
