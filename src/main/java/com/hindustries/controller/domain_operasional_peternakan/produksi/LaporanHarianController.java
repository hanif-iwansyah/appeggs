package com.hindustries.controller.domain_operasional_peternakan.produksi;

import com.hindustries.base.BaseController;
import com.hindustries.base.BaseService;
import com.hindustries.dto.request.system.LaporanHarianRequest;
import com.hindustries.dto.response.system.LaporanHarianResponse;
import com.hindustries.service.domain.laporan.LaporanHarianService;

/*@RestController
@RequestMapping("/api/laporan-harian")*/
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