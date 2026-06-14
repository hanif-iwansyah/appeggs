package com.hindustries.controller.farm;

import com.hindustries.base.BaseController;
import com.hindustries.base.BaseService;
import com.hindustries.dto.request.commerce.PengakiranAyamRequest;
import com.hindustries.dto.response.farm.PengakiranAyamResponse;
import com.hindustries.service.farm.PengakiranAyamService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pengakiran-ayam")
public class PengakiranAyamController extends BaseController<PengakiranAyamRequest, PengakiranAyamResponse, Long> {
    private final PengakiranAyamService service;
    public PengakiranAyamController(PengakiranAyamService service) {
        this.service = service;
    }
    @Override
    protected BaseService<PengakiranAyamRequest, PengakiranAyamResponse, Long> getService() {
        return service;
    }
}
