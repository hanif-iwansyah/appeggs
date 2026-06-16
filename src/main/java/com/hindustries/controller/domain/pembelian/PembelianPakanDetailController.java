package com.hindustries.controller.domain.pembelian;

import com.hindustries.base.BaseController;
import com.hindustries.base.BaseService;
import com.hindustries.dto.request.domain.pembelian.PembelianPakanDetailRequest;
import com.hindustries.dto.response.domain.pembelian.PembelianPakanDetailResponse;
import com.hindustries.service.domain.pembelian.PembelianPakanDetailService;

/*@RestController
@RequestMapping("/api/pembelian-pakan-detail")*/
public class PembelianPakanDetailController extends BaseController<PembelianPakanDetailRequest, PembelianPakanDetailResponse, Long> {
    private final PembelianPakanDetailService service;
    public PembelianPakanDetailController(PembelianPakanDetailService service) {
        this.service = service;
    }
    @Override
    protected BaseService<PembelianPakanDetailRequest, PembelianPakanDetailResponse, Long> getService() {
        return service;
    }
}