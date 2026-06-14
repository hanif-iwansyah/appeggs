package com.hindustries.controller.domain_master_data;

import com.hindustries.base.BaseController;
import com.hindustries.base.BaseService;
import com.hindustries.dto.request.master.PemasokRequest;
import com.hindustries.dto.response.master.PemasokResponse;
import com.hindustries.service.domain.master.PemasokService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pemasok")
public class PemasokController extends BaseController<PemasokRequest, PemasokResponse, Long> {
    private final PemasokService service;
    public PemasokController(PemasokService service) {
        this.service = service;
    }
    @Override
    protected BaseService<PemasokRequest, PemasokResponse, Long> getService() {
        return service;
    }
}
