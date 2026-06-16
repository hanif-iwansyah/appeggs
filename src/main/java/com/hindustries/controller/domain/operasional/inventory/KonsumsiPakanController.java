package com.hindustries.controller.domain.operasional.inventory;

import com.hindustries.base.BaseController;
import com.hindustries.base.BaseService;
import com.hindustries.dto.request.domain.operasional.inventory.KonsumsiPakanRequest;
import com.hindustries.dto.response.domain.operasional.inventory.KonsumsiPakanResponse;
import com.hindustries.service.domain.operasional.inventory.KonsumsiPakanService;

/*@RestController
@RequestMapping("/api/konsumsi-pakan")*/
public class KonsumsiPakanController extends BaseController<KonsumsiPakanRequest, KonsumsiPakanResponse, Long> {
    private final KonsumsiPakanService service;
    public KonsumsiPakanController(KonsumsiPakanService service) {
        this.service = service;
    }
    @Override
    protected BaseService<KonsumsiPakanRequest, KonsumsiPakanResponse, Long> getService() {
        return service;
    }
}
