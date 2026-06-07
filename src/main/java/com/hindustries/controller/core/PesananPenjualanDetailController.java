package com.hindustries.controller.core;

import com.hindustries.base.BaseController;
import com.hindustries.base.BaseService;
import com.hindustries.dto.request.core.PesananPenjualanDetailRequest;
import com.hindustries.dto.request.core.PesananPenjualanRequest;
import com.hindustries.dto.response.core.PesananPenjualanDetailResponse;
import com.hindustries.dto.response.core.PesananPenjualanResponse;
import com.hindustries.service.core.PesananPenjualanDetailService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pesanan-penjualan-detail")
public class PesananPenjualanDetailController extends BaseController<PesananPenjualanDetailRequest, PesananPenjualanDetailResponse, Long> {
    private final PesananPenjualanDetailService service;
    public PesananPenjualanDetailController(PesananPenjualanDetailService service) {
        this.service = service;
    }
    @Override
    protected BaseService<PesananPenjualanDetailRequest, PesananPenjualanDetailResponse, Long> getService() {
        return service;
    }
}