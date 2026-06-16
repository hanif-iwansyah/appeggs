package com.hindustries.controller.domain.operasional.inventory;

import com.hindustries.base.BaseController;
import com.hindustries.base.BaseService;
import com.hindustries.dto.request.domain.operasional.inventory.StokPakanRequest;
import com.hindustries.dto.response.domain.operasional.inventory.StokPakanResponse;
import com.hindustries.service.domain.operasional.inventory.StokPakanService;

/*@RestController
@RequestMapping("/api/stok-pakan")*/
public class StokPakanController extends BaseController<StokPakanRequest, StokPakanResponse, Long> {
    private final StokPakanService service;
    public StokPakanController(StokPakanService service) {
        this.service = service;
    }
    @Override
    protected BaseService<StokPakanRequest, StokPakanResponse, Long> getService() {
        return service;
    }
}

