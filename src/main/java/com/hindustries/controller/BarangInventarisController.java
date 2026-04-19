package com.hindustries.controller;

import com.hindustries.base.BaseController;
import com.hindustries.base.BaseService;
import com.hindustries.dto.request.BarangInventarisRequest;
import com.hindustries.dto.response.BarangInventarisResponse;
import com.hindustries.service.BarangInventarisService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/barang-inventaris")
public class BarangInventarisController extends BaseController<BarangInventarisRequest, BarangInventarisResponse, Long> {

    private final BarangInventarisService service;

    public BarangInventarisController(BarangInventarisService service) {
        this.service = service;
    }

    @Override
    protected BaseService<BarangInventarisRequest, BarangInventarisResponse, Long> getService() {
        return service;
    }
}
