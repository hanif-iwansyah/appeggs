package com.hindustries.controller.domain.penjualan;

import com.hindustries.dto.request.domain.penjualan.PembayaranRequest;
import com.hindustries.dto.response.domain.penjualan.OutstandingPembayaranResponse;
import com.hindustries.entity.domain.penjualan.Pembayaran;
import com.hindustries.repository.domain.penjualan.PesananPenjualanRepository;
import com.hindustries.service.domain.penjualan.PembayaranService;
import com.hindustries.util.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/pembayaran")
public class PembayaranController {
    private final PembayaranService service;
    private final PesananPenjualanRepository pesananPenjualanRepository;

    public PembayaranController(PembayaranService service, PesananPenjualanRepository pesananPenjualanRepository) {
        this.service = service;
        this.pesananPenjualanRepository = pesananPenjualanRepository;
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<Pembayaran>> create(PembayaranRequest request) {
        return ResponseEntity.ok(ApiResponse.success(service.create(request)));
    }

    @GetMapping("/outstanding")
    public ResponseEntity<List<OutstandingPembayaranResponse>> getOutStanding(@RequestParam("pelangganId") Long pelangganId) {
        List<OutstandingPembayaranResponse> responses = service.getOutstanding(pelangganId);
        return ResponseEntity.ok(responses);
    }

}
