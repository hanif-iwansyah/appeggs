package com.hindustries.controller.domain.pembelian;

import com.hindustries.base.BaseController;
import com.hindustries.base.BaseService;
import com.hindustries.dto.request.domain.pembelian.PembelianPakanRequest;
import com.hindustries.dto.response.domain.pembelian.PembelianPakanResponse;
import com.hindustries.service.domain.pembelian.PembelianPakanService;


/*@RestController
@RequestMapping("/api/pembelian-pakan")*/
public class PembelianPakanController extends BaseController<PembelianPakanRequest, PembelianPakanResponse, Long> {
    private final PembelianPakanService service;
    public PembelianPakanController(PembelianPakanService service) {
        this.service = service;
    }
    @Override
    protected BaseService<PembelianPakanRequest, PembelianPakanResponse, Long> getService() {
        return service;
    }
}