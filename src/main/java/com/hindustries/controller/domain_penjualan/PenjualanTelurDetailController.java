package com.hindustries.controller.domain_penjualan;

import com.hindustries.base.BaseController;
import com.hindustries.base.BaseService;
import com.hindustries.dto.request.commerce.PenjualanTelurDetailRequest;
import com.hindustries.dto.response.commerce.PenjualanTelurDetailResponse;
import com.hindustries.service.commerce.PenjualanTelurDetailService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//@RequestMapping("/api/penjualan-telur-detail")
public class PenjualanTelurDetailController extends BaseController<PenjualanTelurDetailRequest, PenjualanTelurDetailResponse, Long> {
    private final PenjualanTelurDetailService service;
    public PenjualanTelurDetailController(PenjualanTelurDetailService service) {
        this.service = service;
    }
    @Override
    protected BaseService<PenjualanTelurDetailRequest, PenjualanTelurDetailResponse, Long> getService() {
        return service;
    }
}