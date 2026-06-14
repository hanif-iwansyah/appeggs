package com.hindustries.controller.domain_master_data;

import com.hindustries.base.BaseController;
import com.hindustries.base.BaseService;
import com.hindustries.dto.request.master.JenisPakanRequest;
import com.hindustries.dto.response.master.JenisPakanResponse;
import com.hindustries.service.domain_master_data.JenisPakanService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/jenis-pakan")
public class JenisPakanController extends BaseController<JenisPakanRequest, JenisPakanResponse, Long> {
    private final JenisPakanService service;
    public JenisPakanController(JenisPakanService service) {
        this.service = service;
    }
    @Override
    protected BaseService<JenisPakanRequest, JenisPakanResponse, Long> getService() {
        return service;
    }
}
