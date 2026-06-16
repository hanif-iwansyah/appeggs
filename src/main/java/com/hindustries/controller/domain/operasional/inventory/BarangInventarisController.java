package com.hindustries.controller.domain.operasional.inventory;

import com.hindustries.base.BaseController;
import com.hindustries.base.BaseService;
import com.hindustries.dto.request.domain.operasional.inventory.BarangInventarisRequest;
import com.hindustries.dto.response.domain.operasional.inventory.BarangInventarisResponse;
import com.hindustries.service.domain.operasional.inventory.BarangInventarisService;

/*@RestController
@RequestMapping("/api/barang-inventaris")*/
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
