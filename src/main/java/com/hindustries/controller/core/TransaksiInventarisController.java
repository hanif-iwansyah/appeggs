package com.hindustries.controller.core;

import com.hindustries.base.BaseController;
import com.hindustries.base.BaseService;
import com.hindustries.dto.request.core.TransaksiInventarisRequest;
import com.hindustries.dto.response.core.TransaksiInventarisResponse;
import com.hindustries.service.core.TransaksiInventarisService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transaksi-invetaris")
public class TransaksiInventarisController extends BaseController<TransaksiInventarisRequest, TransaksiInventarisResponse, Long> {
    private final TransaksiInventarisService service;

    public TransaksiInventarisController(TransaksiInventarisService service) {
        this.service = service;
    }

    @Override
    protected BaseService<TransaksiInventarisRequest, TransaksiInventarisResponse, Long> getService() {
        return service;
    }
}