package com.hindustries.controller.farm;

import com.hindustries.base.BaseController;
import com.hindustries.base.BaseService;
import com.hindustries.dto.request.farm.CatatanVaksinasiRequest;
import com.hindustries.dto.response.farm.CatatanVaksinasiResponse;
import com.hindustries.service.farm.CatatanVaksinasiService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/catatan-vaksinasi")
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
