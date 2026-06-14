package com.hindustries.controller.commerce;

import com.hindustries.base.BaseController;
import com.hindustries.base.BaseService;
import com.hindustries.dto.request.commerce.PengirimanRequest;
import com.hindustries.dto.response.commerce.PengirimanResponse;
import com.hindustries.service.commerce.PengirimanService;
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