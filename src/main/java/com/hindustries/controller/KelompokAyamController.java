package com.hindustries.controller;

import com.hindustries.base.BaseController;
import com.hindustries.base.BaseService;
import com.hindustries.dto.request.KelompokAyamRequest;
import com.hindustries.dto.response.KelompokAyamResponse;
import com.hindustries.service.KelompokAyamService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/kelompok-ayam")
public class KelompokAyamController extends BaseController<KelompokAyamRequest, KelompokAyamResponse, Long> {
    private final KelompokAyamService service;
    public KelompokAyamController(KelompokAyamService service) {
        this.service = service;
    }
    @Override
    protected BaseService<KelompokAyamRequest, KelompokAyamResponse, Long> getService() {
        return service;
    }
}
