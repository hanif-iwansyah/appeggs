package com.hindustries.controller.core;

import com.hindustries.base.BaseController;
import com.hindustries.base.BaseService;
import com.hindustries.dto.request.core.PembelianPakanDetailRequest;
import com.hindustries.dto.response.core.PembelianPakanDetailResponse;
import com.hindustries.service.core.PembelianPakanDetailService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pembelian-pakan-detail")
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