package com.hindustries.controller;

import com.hindustries.base.BaseController;
import com.hindustries.base.BaseService;
import com.hindustries.dto.request.KematianAyamRequest;
import com.hindustries.dto.response.KematianAyamResponse;
import com.hindustries.service.KematianAyamService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/kematian-ayam")
public class KematianAyamController extends BaseController<KematianAyamRequest, KematianAyamResponse, Long> {

    private final KematianAyamService service;

    public KematianAyamController(KematianAyamService service) {
        this.service = service;
    }

    @Override
    protected BaseService<KematianAyamRequest, KematianAyamResponse, Long> getService() {
        return service;
    }
}
