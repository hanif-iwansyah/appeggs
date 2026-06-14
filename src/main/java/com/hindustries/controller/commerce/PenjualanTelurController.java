package com.hindustries.controller.commerce;

import com.hindustries.base.BaseController;
import com.hindustries.base.BaseService;
import com.hindustries.dto.request.commerce.PenjualanTelurRequest;
import com.hindustries.dto.response.commerce.PenjualanTelurResponse;
import com.hindustries.service.commerce.PenjualanTelurService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/penjualan-telur")
public class PenjualanTelurController extends BaseController<PenjualanTelurRequest, PenjualanTelurResponse, Long> {
    private final PenjualanTelurService service;
    public PenjualanTelurController(PenjualanTelurService service) {
        this.service = service;
    }
    @Override
    protected BaseService<PenjualanTelurRequest, PenjualanTelurResponse, Long> getService() {
        return service;
    }
}