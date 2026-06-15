package com.hindustries.controller.domain_pembelian;

import com.hindustries.base.BaseController;
import com.hindustries.base.BaseService;
import com.hindustries.dto.request.commerce.PembelianPakanRequest;
import com.hindustries.dto.response.commerce.PembelianPakanResponse;
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