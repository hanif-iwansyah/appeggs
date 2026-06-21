package com.hindustries.controller.domain.operasional.inventory;

import com.hindustries.dto.request.domain.operasional.inventory.InventarisRequest;
import com.hindustries.service.domain.operasional.inventory.InventarisService;
import com.hindustries.util.ApiResponse;
import com.hindustries.util.Constant;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventaris")
public class InventarisController {
    private final InventarisService service;

    public InventarisController(InventarisService service) {
        this.service = service;
    }

    @PostMapping("/masuk")
    public ResponseEntity<ApiResponse<String>> barangMasuk(@Valid @RequestBody InventarisRequest request) {
        service.kelolaBarangMasuk(request);
        return ResponseEntity.ok(ApiResponse.success(Constant.STOCK_IN_SUCCESS.apply(request.getKategori())));
    }

    @PostMapping("/keluar")
    public ResponseEntity<ApiResponse<String>> barangKeluar(@Valid @RequestBody InventarisRequest request) {
        service.kelolaBarangKeluar(request);
        return ResponseEntity.ok(ApiResponse.success(Constant.STOCK_IN_SUCCESS.apply(request.getKategori())));
    }

}
