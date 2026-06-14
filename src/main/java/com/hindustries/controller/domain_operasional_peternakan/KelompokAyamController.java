package com.hindustries.controller.domain_operasional_peternakan;

import com.hindustries.base.BaseController;
import com.hindustries.base.BaseService;
import com.hindustries.dto.request.farm.KelompokAyamRequest;
import com.hindustries.dto.response.farm.KelompokAyamResponse;
import com.hindustries.dto.response.farm.KelompokAyamRingkasanResponse;
import com.hindustries.service.farm.KelompokAyamService;
import com.hindustries.util.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*@RestController
@RequestMapping("/api/kelompok-ayam")*/
public class KelompokAyamController extends BaseController<KelompokAyamRequest, KelompokAyamResponse, Long> {
    private final KelompokAyamService service;

    public KelompokAyamController(KelompokAyamService service) {
        this.service = service;
    }

    @Override
    protected BaseService<KelompokAyamRequest, KelompokAyamResponse, Long> getService() {
        return service;
    }

    @GetMapping("/ringkasan/{id}")
    public ResponseEntity<ApiResponse<KelompokAyamRingkasanResponse>> getRingkasan(@PathVariable Long id) {
        return ResponseEntity.ok(ApiResponse.success(service.findRingkasan(id)));
    }
}
