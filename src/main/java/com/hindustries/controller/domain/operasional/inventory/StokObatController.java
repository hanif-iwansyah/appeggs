package com.hindustries.controller.domain.operasional.inventory;

import com.hindustries.base.BaseController;
import com.hindustries.base.BaseService;
import com.hindustries.dto.request.domain.operasional.inventory.StokObatRequest;
import com.hindustries.dto.response.domain.operasional.inventory.StokObatResponse;
import com.hindustries.service.domain.operasional.inventory.StokObatService;

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
