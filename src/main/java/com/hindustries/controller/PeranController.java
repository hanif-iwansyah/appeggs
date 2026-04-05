package com.hindustries.controller;

import com.hindustries.base.BaseController;
import com.hindustries.base.BaseService;
import com.hindustries.dto.request.PeranRequest;
import com.hindustries.dto.response.PeranResponse;
import com.hindustries.service.PeranService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/peran")
public class PeranController extends BaseController<PeranRequest, PeranResponse, Long> {

    private final PeranService service;

    public PeranController(PeranService service) {
        this.service = service;
    }

    @Override
    protected BaseService<PeranRequest, PeranResponse, Long> getService() {
        return service;
    }
}
