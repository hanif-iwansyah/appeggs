package com.hindustries.controller.domain.master;

import com.hindustries.base.BaseController;
import com.hindustries.base.BaseService;
import com.hindustries.dto.request.master.KandangRequest;
import com.hindustries.dto.response.master.KandangResponse;
import com.hindustries.service.domain.master.KandangService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/kandang")
public class KandangController extends BaseController<KandangRequest, KandangResponse, Long> {
    private final KandangService service;
    public KandangController(KandangService service) {
        this.service = service;
    }
    @Override
    protected BaseService<KandangRequest, KandangResponse, Long> getService() {
        return service;
    }
}
