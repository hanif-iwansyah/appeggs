package com.hindustries.controller.domain_master_data;

import com.hindustries.base.BaseController;
import com.hindustries.base.BaseService;
import com.hindustries.dto.request.master.RasAyamRequest;
import com.hindustries.dto.response.master.RasAyamResponse;
import com.hindustries.service.domain_master_data.RasAyamService;
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
