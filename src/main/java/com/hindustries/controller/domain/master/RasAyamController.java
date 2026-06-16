package com.hindustries.controller.domain.master;

import com.hindustries.base.BaseController;
import com.hindustries.base.BaseService;
import com.hindustries.dto.request.domain.master.RasAyamRequest;
import com.hindustries.dto.response.domain.master.RasAyamResponse;
import com.hindustries.service.domain.master.RasAyamService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ras-ayam")
public class RasAyamController extends BaseController<RasAyamRequest, RasAyamResponse, Long> {
    private final RasAyamService service;
    public RasAyamController(RasAyamService service) {
        this.service = service;
    }
    @Override
    protected BaseService<RasAyamRequest, RasAyamResponse, Long> getService() {
        return service;
    }
}
