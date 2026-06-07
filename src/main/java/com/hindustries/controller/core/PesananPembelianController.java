package com.hindustries.controller.core;

import com.hindustries.base.BaseController;
import com.hindustries.base.BaseService;
import com.hindustries.dto.request.core.PesananPembelianRequest;
import com.hindustries.dto.response.core.PesananPembelianResponse;
import com.hindustries.service.core.PesananPembelianService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pesanan-pembelian")
public class PesananPembelianController extends BaseController<PesananPembelianRequest, PesananPembelianResponse, Long> {
    private final PesananPembelianService service;
    public PesananPembelianController(PesananPembelianService service) {
        this.service = service;
    }
    @Override
    protected BaseService<PesananPembelianRequest, PesananPembelianResponse, Long> getService() {
        return service;
    }
}