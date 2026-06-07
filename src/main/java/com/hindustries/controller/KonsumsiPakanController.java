package com.hindustries.controller;

import com.hindustries.base.BaseController;
import com.hindustries.base.BaseService;
import com.hindustries.dto.request.KonsumsiPakanRequest;
import com.hindustries.dto.response.KonsumsiPakanResponse;
import com.hindustries.service.KonsumsiPakanService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/konsumsi-pakan")
public class KonsumsiPakanController extends BaseController<KonsumsiPakanRequest, KonsumsiPakanResponse, Long> {
    private final KonsumsiPakanService service;
    public KonsumsiPakanController(KonsumsiPakanService service) {
        this.service = service;
    }
    @Override
    protected BaseService<KonsumsiPakanRequest, KonsumsiPakanResponse, Long> getService() {
        return service;
    }
}
