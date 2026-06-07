package com.hindustries.controller.core;

import com.hindustries.base.BaseController;
import com.hindustries.base.BaseService;
import com.hindustries.dto.request.core.LaporanHarianRequest;
import com.hindustries.dto.response.core.LaporanHarianResponse;
import com.hindustries.service.core.LaporanHarianService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/laporan-harian")
public class LaporanHarianController extends BaseController<LaporanHarianRequest, LaporanHarianResponse, Long> {
    private final LaporanHarianService service;
    public LaporanHarianController(LaporanHarianService service) {
        this.service = service;
    }
    @Override
    protected BaseService<LaporanHarianRequest, LaporanHarianResponse, Long> getService() {
        return service;
    }
}