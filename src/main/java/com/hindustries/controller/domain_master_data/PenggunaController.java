package com.hindustries.controller.domain_master_data;

import com.hindustries.base.BaseController;
import com.hindustries.base.BaseService;
import com.hindustries.dto.request.system.PenggunaRequest;
import com.hindustries.dto.response.system.PenggunaResponse;
import com.hindustries.service.domain_master_data.PenggunaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pengguna")
public class PenggunaController extends BaseController<PenggunaRequest, PenggunaResponse, Long> {
    private final PenggunaService service;
    public PenggunaController(PenggunaService service) {
        this.service = service;
    }
    @Override
    protected BaseService<PenggunaRequest, PenggunaResponse, Long> getService() {
        return service;
    }
}
