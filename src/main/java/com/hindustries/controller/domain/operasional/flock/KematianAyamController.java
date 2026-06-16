package com.hindustries.controller.domain.operasional.flock;

import com.hindustries.base.BaseController;
import com.hindustries.base.BaseService;
import com.hindustries.dto.request.domain.operasional.flock.KematianAyamRequest;
import com.hindustries.dto.response.domain.operasional.flock.KematianAyamResponse;
import com.hindustries.service.domain.operasional.flock.KematianAyamService;

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
