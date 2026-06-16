package com.hindustries.controller.domain.operasional.inventory;

import com.hindustries.base.BaseController;
import com.hindustries.base.BaseService;
import com.hindustries.dto.request.domain.operasional.inventory.StokTelurRequest;
import com.hindustries.dto.response.domain.operasional.inventory.StokTelurResponse;
import com.hindustries.service.domain.operasional.inventory.StokTelurService;

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
