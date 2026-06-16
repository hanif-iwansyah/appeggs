package com.hindustries.controller.domain.operasional.health;

import com.hindustries.base.BaseController;
import com.hindustries.base.BaseService;
import com.hindustries.dto.request.domain.operasional.health.JadwalVaksinRequest;
import com.hindustries.dto.response.domain.operasional.health.JadwalVaksinResponse;
import com.hindustries.service.domain.operasional.health.JadwalVaksinService;

/*@RestController
@RequestMapping("/api/jadwal-vaksin")*/
public class JadwalVaksinController extends BaseController<JadwalVaksinRequest, JadwalVaksinResponse, Long> {
    private final JadwalVaksinService service;
    public JadwalVaksinController(JadwalVaksinService service) {
        this.service = service;
    }
    @Override
    protected BaseService<JadwalVaksinRequest, JadwalVaksinResponse, Long> getService() {
        return service;
    }
}
