package com.hindustries.controller.domain.penjualan;

import com.hindustries.base.BaseController;
import com.hindustries.base.BaseService;
import com.hindustries.dto.request.domain.penjualan.PesananPenjualanDetailRequest;
import com.hindustries.dto.response.domain.penjualan.PesananPenjualanDetailResponse;
import com.hindustries.service.domain.penjualan.PesananPenjualanDetailService;

/*@RestController
@RequestMapping("/api/pesanan-penjualan-detail")*/
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