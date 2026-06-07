package com.hindustries.controller;

import com.hindustries.base.BaseController;
import com.hindustries.base.BaseService;
import com.hindustries.dto.request.StokObatRequest;
import com.hindustries.dto.response.StokObatResponse;
import com.hindustries.service.StokObatService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/stok-obat")
public class StokObatController extends BaseController<StokObatRequest, StokObatResponse, Long> {
    private final StokObatService service;
    public StokObatController(StokObatService service) {
        this.service = service;
    }
    @Override
    protected BaseService<StokObatRequest, StokObatResponse, Long> getService() {
        return service;
    }
}
