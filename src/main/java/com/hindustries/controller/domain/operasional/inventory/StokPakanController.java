package com.hindustries.controller.domain.operasional.inventory;

import com.hindustries.dto.response.domain.operasional.inventory.StokPakanAlertResponse;
import com.hindustries.service.domain.operasional.inventory.StokPakanService;
import com.hindustries.util.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/stok-pakan")
public class StokPakanController {

    private final StokPakanService service;

    public StokPakanController(StokPakanService service) {
        this.service = service;
    }

    @GetMapping("/alert")
    public ResponseEntity<ApiResponse<List<StokPakanAlertResponse>>> getAlert() {
        return ResponseEntity.ok(ApiResponse.success(service.getAlert()));
    }


}

