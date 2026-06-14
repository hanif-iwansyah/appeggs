package com.hindustries.controller.domain_persediaan.inventory;

import com.hindustries.base.BaseController;
import com.hindustries.base.BaseService;
import com.hindustries.dto.request.inventory.StokPakanRequest;
import com.hindustries.dto.response.inventory.StokPakanResponse;
import com.hindustries.service.inventory.StokPakanService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

