package com.hindustries.controller.domain_pembelian;

import com.hindustries.base.BaseController;
import com.hindustries.base.BaseService;
import com.hindustries.dto.request.commerce.PesananPembelianRequest;
import com.hindustries.dto.response.commerce.PesananPembelianResponse;
import com.hindustries.service.domain.pembelian.PesananPembelianService;

/*@RestController
@RequestMapping("/api/pesanan-pembelian")*/
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