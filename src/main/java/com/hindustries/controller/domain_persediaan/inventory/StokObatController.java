package com.hindustries.controller.domain_persediaan.inventory;

import com.hindustries.base.BaseController;
import com.hindustries.base.BaseService;
import com.hindustries.dto.request.inventory.StokObatRequest;
import com.hindustries.dto.response.inventory.StokObatResponse;
import com.hindustries.service.inventory.StokObatService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*@RestController
@RequestMapping("/api/stok-obat")*/
public class StokObatController extends BaseController<StokObatRequest, StokObatResponse, Long> {
    private final StokObatService service;
    public StokObatController(StokObatService service) {
        this.service = service;
    }
    @Override
    protected BaseService<StokObatRequest, StokObatResponse, Long> getService() {
        return service;
    }
}
