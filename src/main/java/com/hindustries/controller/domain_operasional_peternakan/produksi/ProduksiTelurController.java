package com.hindustries.controller.domain_operasional_peternakan.produksi;

import com.hindustries.base.BaseController;
import com.hindustries.base.BaseService;
import com.hindustries.dto.request.farm.ProduksiTelurRequest;
import com.hindustries.dto.response.farm.ProduksiTelurResponse;
import com.hindustries.service.farm.ProduksiTelurService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
