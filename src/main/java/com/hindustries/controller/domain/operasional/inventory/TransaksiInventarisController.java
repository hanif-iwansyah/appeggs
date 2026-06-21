
package com.hindustries.controller.domain.operasional.inventory;

import com.hindustries.dto.response.domain.operasional.inventory.TransaksiInventarisDetailResponse;
import com.hindustries.service.domain.operasional.inventory.TransaksiInventarisService;
import com.hindustries.util.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/transaksi-inventaris")
public class TransaksiInventarisController {
    private final TransaksiInventarisService service;
    public TransaksiInventarisController(TransaksiInventarisService service) { this.service = service; }
    @GetMapping("/{id}/riwayat")
    public ResponseEntity<ApiResponse<List<TransaksiInventarisDetailResponse>>> getRiwayatInventaris(@PathVariable Long id) {
        return ResponseEntity.ok(ApiResponse.success(service.getRiwayat(id)));
    }
}