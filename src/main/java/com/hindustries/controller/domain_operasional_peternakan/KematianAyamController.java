package com.hindustries.controller.domain_operasional_peternakan;

import com.hindustries.base.BaseController;
import com.hindustries.base.BaseService;
import com.hindustries.dto.request.farm.KematianAyamRequest;
import com.hindustries.dto.response.farm.KematianAyamResponse;
import com.hindustries.service.farm.KematianAyamService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*@RestController
@RequestMapping("/api/kematian-ayam")*/
public class KematianAyamController extends BaseController<KematianAyamRequest, KematianAyamResponse, Long> {
    private final KematianAyamService service;
    public KematianAyamController(KematianAyamService service) {
        this.service = service;
    }
    @Override
    protected BaseService<KematianAyamRequest, KematianAyamResponse, Long> getService() {
        return service;
    }
}
