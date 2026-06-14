package com.hindustries.controller.inventory;

import com.hindustries.base.BaseController;
import com.hindustries.base.BaseService;
import com.hindustries.dto.request.inventory.GudangRequest;
import com.hindustries.dto.response.inventory.GudangResponse;
import com.hindustries.service.inventory.GudangService;
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
