package com.hindustries.controller.core;

import com.hindustries.base.BaseController;
import com.hindustries.base.BaseService;
import com.hindustries.dto.request.core.PengirimanRequest;
import com.hindustries.dto.response.core.PengirimanResponse;
import com.hindustries.service.core.PengirimanService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pengiriman")
public class PengirimanController extends BaseController<PengirimanRequest, PengirimanResponse, Long> {
    private final PengirimanService service;
    public PengirimanController(PengirimanService service) {
        this.service = service;
    }
    @Override
    protected BaseService<PengirimanRequest, PengirimanResponse, Long> getService() {
        return service;
    }
}