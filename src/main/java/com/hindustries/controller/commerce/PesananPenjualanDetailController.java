package com.hindustries.controller.commerce;

import com.hindustries.base.BaseController;
import com.hindustries.base.BaseService;
import com.hindustries.dto.request.commerce.PesananPenjualanDetailRequest;
import com.hindustries.dto.response.commerce.PesananPenjualanDetailResponse;
import com.hindustries.service.commerce.PesananPenjualanDetailService;
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