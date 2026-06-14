package com.hindustries.controller.domain_penjualan;

import com.hindustries.base.BaseController;
import com.hindustries.base.BaseService;
import com.hindustries.dto.request.commerce.PesananPenjualanRequest;
import com.hindustries.dto.response.commerce.PesananPenjualanResponse;
import com.hindustries.service.commerce.PesananPenjualanService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*@RestController
@RequestMapping("/api/pesanan-penjualan")*/
public class PesananPenjualanController extends BaseController<PesananPenjualanRequest, PesananPenjualanResponse, Long> {
    private final PesananPenjualanService service;
    public PesananPenjualanController(PesananPenjualanService service) {
        this.service = service;
    }
    @Override
    protected BaseService<PesananPenjualanRequest, PesananPenjualanResponse, Long> getService() {
        return service;
    }
}