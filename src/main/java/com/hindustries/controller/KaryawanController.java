package com.hindustries.controller;

import com.hindustries.base.BaseController;
import com.hindustries.base.BaseService;
import com.hindustries.dto.request.KaryawanRequest;
import com.hindustries.dto.response.KaryawanResponse;
import com.hindustries.service.KaryawanService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/karyawan")
public class KaryawanController extends BaseController<KaryawanRequest, KaryawanResponse, Long> {
    private final KaryawanService service;
    public KaryawanController(KaryawanService service) {
        this.service = service;
    }
    @Override
    protected BaseService<KaryawanRequest, KaryawanResponse, Long> getService() {
        return service;
    }
}
