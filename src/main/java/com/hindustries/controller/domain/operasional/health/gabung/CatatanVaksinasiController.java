package com.hindustries.controller.domain.operasional.health.gabung;

import com.hindustries.base.BaseController;
import com.hindustries.base.BaseService;
import com.hindustries.dto.request.domain.operasional.health.CatatanVaksinasiRequest;
import com.hindustries.dto.response.domain.operasional.health.CatatanVaksinasiResponse;
import com.hindustries.service.domain.operasional.health.CatatanVaksinasiService;

/*@RestController
@RequestMapping("/api/catatan-vaksinasi")*/
public class CatatanVaksinasiController extends BaseController<CatatanVaksinasiRequest, CatatanVaksinasiResponse, Long> {
    private final CatatanVaksinasiService service;
    public CatatanVaksinasiController(CatatanVaksinasiService service) {
        this.service = service;
    }
    @Override
    protected BaseService<CatatanVaksinasiRequest, CatatanVaksinasiResponse, Long> getService() {
        return service;
    }
}
