package com.hindustries.controller.core;

import com.hindustries.base.BaseController;
import com.hindustries.base.BaseService;
import com.hindustries.dto.request.core.PembelianPakanRequest;
import com.hindustries.dto.response.core.PembelianPakanResponse;
import com.hindustries.service.core.PembelianPakanService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/pembelian-pakan")
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