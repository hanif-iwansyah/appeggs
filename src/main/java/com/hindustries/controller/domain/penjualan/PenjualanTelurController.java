package com.hindustries.controller.domain.penjualan;

import com.hindustries.base.BaseController;
import com.hindustries.base.BaseService;
import com.hindustries.dto.request.domain.penjualan.PenjualanTelurRequest;
import com.hindustries.dto.response.domain.penjualan.PenjualanTelurResponse;
import com.hindustries.service.domain.penjualan.PenjualanTelurService;

/*@RestController
@RequestMapping("/api/penjualan-telur")*/
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