package com.hindustries.controller.domain.pembelian;

import com.hindustries.dto.response.domain.pembelian.PembelianPakanResponse;
import com.hindustries.service.domain.pembelian.PembelianPakanService;
import com.hindustries.util.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pembelian-pakan")
public class PembelianPakanController {
    private final PembelianPakanService service;

    public PembelianPakanController(PembelianPakanService service) {
        this.service = service;
    }

    @PatchMapping("/{id}/terima")
    public ResponseEntity<ApiResponse<PembelianPakanResponse>> terimaBarang(@PathVariable Long id) {
        return ResponseEntity.ok(ApiResponse.success(service.terimaBarang(id)));
    }

}