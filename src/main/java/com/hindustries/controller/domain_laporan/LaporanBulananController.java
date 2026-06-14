package com.hindustries.controller.domain_laporan;

import com.hindustries.base.BaseController;
import com.hindustries.base.BaseService;
import com.hindustries.dto.request.system.LaporanBulananRequest;
import com.hindustries.dto.response.system.LaporanBulananResponse;
import com.hindustries.service.system.LaporanBulananService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//@RequestMapping("/api/laporan-bulanan")
public class LaporanBulananController extends BaseController<LaporanBulananRequest, LaporanBulananResponse, Long> {
    private final LaporanBulananService service;
    public LaporanBulananController(LaporanBulananService service) {
        this.service = service;
    }
    @Override
    protected BaseService<LaporanBulananRequest, LaporanBulananResponse, Long> getService() {
        return service;
    }
}