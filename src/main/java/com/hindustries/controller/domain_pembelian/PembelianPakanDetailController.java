package com.hindustries.controller.domain_pembelian;

import com.hindustries.base.BaseController;
import com.hindustries.base.BaseService;
import com.hindustries.dto.request.commerce.PembelianPakanDetailRequest;
import com.hindustries.dto.response.commerce.PembelianPakanDetailResponse;
import com.hindustries.service.commerce.PembelianPakanDetailService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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