package com.hindustries.controller;

import com.hindustries.base.BaseController;
import com.hindustries.base.BaseService;
import com.hindustries.dto.request.PeternakanRequest;
import com.hindustries.dto.response.PeternakanResponse;
import com.hindustries.service.PeternakanService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/peternakan")
public class PeternakanController extends BaseController<PeternakanRequest, PeternakanResponse, Long> {

    private final PeternakanService service;

    public PeternakanController(PeternakanService service) {
        this.service = service;
    }

    @Override
    protected BaseService<PeternakanRequest, PeternakanResponse, Long> getService() {
        return service;
    }

}


