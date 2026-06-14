package com.hindustries.controller.domain_persediaan.inventory;

import com.hindustries.base.BaseController;
import com.hindustries.base.BaseService;
import com.hindustries.dto.request.inventory.TransaksiInventarisRequest;
import com.hindustries.dto.response.inventory.TransaksiInventarisResponse;
import com.hindustries.service.inventory.TransaksiInventarisService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*@RestController
@RequestMapping("/api/transaksi-inventaris")*/
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