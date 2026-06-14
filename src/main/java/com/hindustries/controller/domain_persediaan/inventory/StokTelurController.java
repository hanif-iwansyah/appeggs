package com.hindustries.controller.domain_persediaan.inventory;

import com.hindustries.base.BaseController;
import com.hindustries.base.BaseService;
import com.hindustries.dto.request.inventory.StokTelurRequest;
import com.hindustries.dto.response.inventory.StokTelurResponse;
import com.hindustries.service.inventory.StokTelurService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*@RestController
@RequestMapping("/api/stok-telur")*/
public class StokTelurController extends BaseController<StokTelurRequest, StokTelurResponse, Long> {
    private final StokTelurService service;
    public StokTelurController(StokTelurService service) {
        this.service = service;
    }
    @Override
    protected BaseService<StokTelurRequest, StokTelurResponse, Long> getService() {
        return service;
    }
}
