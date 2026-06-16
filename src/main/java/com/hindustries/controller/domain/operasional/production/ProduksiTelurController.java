package com.hindustries.controller.domain.operasional.production;

import com.hindustries.base.BaseController;
import com.hindustries.base.BaseService;
import com.hindustries.dto.request.domain.operasional.production.ProduksiTelurRequest;
import com.hindustries.dto.response.domain.operasional.production.ProduksiTelurResponse;
import com.hindustries.service.domain.operasional.production.ProduksiTelurService;

/*@RestController
@RequestMapping("/api/produksi-telur")*/
public class ProduksiTelurController extends BaseController<ProduksiTelurRequest, ProduksiTelurResponse, Long> {
    private final ProduksiTelurService service;
    public ProduksiTelurController(ProduksiTelurService service) {
        this.service = service;
    }
    @Override
    protected BaseService<ProduksiTelurRequest, ProduksiTelurResponse, Long> getService() {
        return service;
    }
}
