package com.hindustries.controller.domain.laporan;

import com.hindustries.base.BaseController;
import com.hindustries.base.BaseService;
import com.hindustries.dto.request.domain.laporan.LaporanBulananRequest;
import com.hindustries.dto.response.domain.laporan.LaporanBulananResponse;
import com.hindustries.service.domain.laporan.LaporanBulananService;

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