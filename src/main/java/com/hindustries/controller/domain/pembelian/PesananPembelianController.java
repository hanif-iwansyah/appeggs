package com.hindustries.controller.domain.pembelian;

import com.hindustries.base.BaseController;
import com.hindustries.base.BaseService;
import com.hindustries.dto.request.domain.pembelian.PesananPembelianRequest;
import com.hindustries.dto.response.domain.pembelian.PesananPembelianResponse;
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