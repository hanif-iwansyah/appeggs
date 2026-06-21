package com.hindustries.controller.domain.operasional.health.gabung;

import com.hindustries.base.BaseController;
import com.hindustries.base.BaseService;
import com.hindustries.dto.request.domain.operasional.health.KasusPenyakitRequest;
import com.hindustries.dto.response.domain.operasional.health.KasusPenyakitResponse;
import com.hindustries.service.domain.operasional.health.KasusPenyakitService;

/*@RestController
@RequestMapping("/api/kasus-penyakit")*/
public class KasusPenyakitController extends BaseController<KasusPenyakitRequest, KasusPenyakitResponse, Long> {
    private final KasusPenyakitService service;
    public KasusPenyakitController(KasusPenyakitService service) {
        this.service = service;
    }
    @Override
    protected BaseService<KasusPenyakitRequest, KasusPenyakitResponse, Long> getService() {
        return service;
    }
}
