package com.hindustries.controller;

import com.hindustries.base.BaseController;
import com.hindustries.base.BaseService;
import com.hindustries.dto.request.GradingTelurRequest;
import com.hindustries.dto.response.GradingTelurResponse;
import com.hindustries.service.GradingTelurService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/grading-telur")
public class GradingTelurController extends BaseController<GradingTelurRequest, GradingTelurResponse, Long> {

    private final GradingTelurService service;

    public GradingTelurController(GradingTelurService service) {
        this.service = service;
    }

    @Override
    protected BaseService<GradingTelurRequest, GradingTelurResponse, Long> getService() {
        return service;
    }
}
