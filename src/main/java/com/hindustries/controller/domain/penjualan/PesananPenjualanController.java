package com.hindustries.controller.domain.penjualan;

import com.hindustries.base.BaseController;
import com.hindustries.base.BaseService;
import com.hindustries.dto.request.domain.penjualan.PesananPenjualanRequest;
import com.hindustries.dto.response.domain.penjualan.PesananPenjualanResponse;
import com.hindustries.entity.domain.penjualan.StatusPesananPenjualan;
import com.hindustries.service.domain.penjualan.PesananPenjualanService;
import com.hindustries.util.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pesanan-penjualan")
public class PesananPenjualanController extends BaseController<PesananPenjualanRequest, PesananPenjualanResponse, Long> {
    private final PesananPenjualanService service;
    public PesananPenjualanController(PesananPenjualanService service) {
        this.service = service;
    }
    @Override
    protected BaseService<PesananPenjualanRequest, PesananPenjualanResponse, Long> getService() {
        return service;
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<ApiResponse<PesananPenjualanResponse>> ubahStatus(@PathVariable Long id, @RequestParam StatusPesananPenjualan status) {
        return ResponseEntity.ok(ApiResponse.success(service.ubahStatus(id,status)));
    }

}