package com.hindustries.controller;

import com.hindustries.base.BaseController;
import com.hindustries.base.BaseService;
import com.hindustries.dto.request.PemasokRequest;
import com.hindustries.dto.response.PemasokResponse;
import com.hindustries.service.PemasokService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pemasok")
public class PemasokController extends BaseController<PemasokRequest, PemasokResponse, Long> {

    private final PemasokService service;

    public PemasokController(PemasokService service) {
        this.service = service;
    }

    @Override
    protected BaseService<PemasokRequest, PemasokResponse, Long> getService() {
        return service;
    }

}
