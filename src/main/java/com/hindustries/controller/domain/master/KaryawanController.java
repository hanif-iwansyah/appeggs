package com.hindustries.controller.domain.master;

import com.hindustries.base.BaseController;
import com.hindustries.base.BaseService;
import com.hindustries.dto.request.domain.master.KaryawanRequest;
import com.hindustries.dto.response.domain.master.KaryawanResponse;
import com.hindustries.service.domain.master.KaryawanService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/karyawan")
public class KaryawanController extends BaseController<KaryawanRequest, KaryawanResponse, Long> {
    private final KaryawanService service;
    public KaryawanController(KaryawanService service) {
        this.service = service;
    }
    @Override
    protected BaseService<KaryawanRequest, KaryawanResponse, Long> getService() {
        return service;
    }
}
