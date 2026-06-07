package com.hindustries.controller;

import com.hindustries.base.BaseController;
import com.hindustries.base.BaseService;
import com.hindustries.dto.request.JadwalVaksinRequest;
import com.hindustries.dto.response.JadwalVaksinResponse;
import com.hindustries.service.JadwalVaksinService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/jadwal-vaksin")
public class JadwalVaksinController extends BaseController<JadwalVaksinRequest, JadwalVaksinResponse, Long> {
    private final JadwalVaksinService service;
    public JadwalVaksinController(JadwalVaksinService service) {
        this.service = service;
    }
    @Override
    protected BaseService<JadwalVaksinRequest, JadwalVaksinResponse, Long> getService() {
        return service;
    }
}
