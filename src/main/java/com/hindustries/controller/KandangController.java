package com.hindustries.controller;

import com.hindustries.base.BaseController;
import com.hindustries.base.BaseService;
import com.hindustries.dto.request.KandangRequest;
import com.hindustries.dto.response.KandangResponse;
import com.hindustries.service.KandangService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/kandang")
public class KandangController extends BaseController<KandangRequest, KandangResponse, Long> {

    private final KandangService service;

    public KandangController(KandangService service) {
        this.service = service;
    }

    @Override
    protected BaseService<KandangRequest, KandangResponse, Long> getService() {
        return service;
    }

}
