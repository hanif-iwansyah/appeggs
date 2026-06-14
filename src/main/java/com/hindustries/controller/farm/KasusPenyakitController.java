package com.hindustries.controller.farm;

import com.hindustries.base.BaseController;
import com.hindustries.base.BaseService;
import com.hindustries.dto.request.farm.KasusPenyakitRequest;
import com.hindustries.dto.response.farm.KasusPenyakitResponse;
import com.hindustries.service.farm.KasusPenyakitService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/kasus-penyakit")
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
