package com.hindustries.controller.domain.penjualan;

import com.hindustries.dto.request.domain.penjualan.PenjualanTelurRequest;
import com.hindustries.dto.response.domain.penjualan.PenjualanTelurResponse;
import com.hindustries.service.domain.penjualan.PenjualanTelurService;
import com.hindustries.util.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/penjualan-telur")
public class PenjualanTelurController {
    private final PenjualanTelurService service;
    public PenjualanTelurController(PenjualanTelurService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<PenjualanTelurResponse>> create(PenjualanTelurRequest request) {
        return ResponseEntity.ok(ApiResponse.success(service.create(request)));
    }
}