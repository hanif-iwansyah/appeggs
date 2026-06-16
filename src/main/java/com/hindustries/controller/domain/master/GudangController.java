package com.hindustries.controller.domain.master;

import com.hindustries.base.BaseController;
import com.hindustries.base.BaseService;
import com.hindustries.dto.request.domain.master.GudangRequest;
import com.hindustries.dto.response.domain.master.GudangResponse;
import com.hindustries.service.domain.master.GudangService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/gudang")
public class GudangController extends BaseController<GudangRequest, GudangResponse, Long> {
    private final GudangService service;
    public GudangController(GudangService service) {
        this.service = service;
    }
    @Override
    protected BaseService<GudangRequest, GudangResponse, Long> getService() {
        return service;
    }
}
