package com.hindustries.controller.domain.master;

import com.hindustries.base.BaseController;
import com.hindustries.base.BaseService;
import com.hindustries.dto.request.master.PelangganRequest;
import com.hindustries.dto.response.master.PelangganResponse;
import com.hindustries.service.domain.master.PelangganService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pelanggan")
public class PelangganController extends BaseController<PelangganRequest, PelangganResponse, Long> {
    private final PelangganService service;
    public PelangganController(PelangganService service) {
        this.service = service;
    };
    @Override
    protected BaseService<PelangganRequest, PelangganResponse, Long> getService() {
        return service;
    }
}
