package com.hindustries.controller.domain.operasional.production;

import com.hindustries.base.BaseController;
import com.hindustries.base.BaseService;
import com.hindustries.dto.request.domain.operasional.production.GradingTelurRequest;
import com.hindustries.dto.response.domain.operasional.production.GradingTelurResponse;
import com.hindustries.service.domain.operasional.production.GradingTelurService;

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
