package com.hindustries.controller;

import com.hindustries.base.BaseController;
import com.hindustries.base.BaseService;
import com.hindustries.dto.request.JenisPakanRequest;
import com.hindustries.dto.response.JenisPakanResponse;
import com.hindustries.service.JenisPakanService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/jenis-pakan")
public class JenisPakanController extends BaseController<JenisPakanRequest, JenisPakanResponse, Long> {

    private final JenisPakanService service;

    public JenisPakanController(JenisPakanService service) {
        this.service = service;
    }

    @Override
    protected BaseService<JenisPakanRequest, JenisPakanResponse, Long> getService() {
        return service;
    }

}
