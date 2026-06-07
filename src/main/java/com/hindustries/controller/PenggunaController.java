package com.hindustries.controller;

import com.hindustries.base.BaseController;
import com.hindustries.base.BaseService;
import com.hindustries.dto.request.PenggunaRequest;
import com.hindustries.dto.response.PenggunaResponse;
import com.hindustries.service.PenggunaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pengguna")
public class PenggunaController extends BaseController<PenggunaRequest, PenggunaResponse, Long> {
    private final PenggunaService service;
    public PenggunaController(PenggunaService service) {
        this.service = service;
    }
    @Override
    protected BaseService<PenggunaRequest, PenggunaResponse, Long> getService() {
        return service;
    }
}
