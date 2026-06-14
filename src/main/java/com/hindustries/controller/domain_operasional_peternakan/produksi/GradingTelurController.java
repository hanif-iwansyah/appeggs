package com.hindustries.controller.domain_operasional_peternakan.produksi;

import com.hindustries.base.BaseController;
import com.hindustries.base.BaseService;
import com.hindustries.dto.request.farm.GradingTelurRequest;
import com.hindustries.dto.response.farm.GradingTelurResponse;
import com.hindustries.service.farm.GradingTelurService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*@RestController
@RequestMapping("/api/grading-telur")*/
public class GradingTelurController extends BaseController<GradingTelurRequest, GradingTelurResponse, Long> {
    private final GradingTelurService service;
    public GradingTelurController(GradingTelurService service) {
        this.service = service;
    }
    @Override
    protected BaseService<GradingTelurRequest, GradingTelurResponse, Long> getService() {
        return service;
    }
}
