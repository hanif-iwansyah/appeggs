package com.hindustries.controller.domain.operasional.inventory;

import com.hindustries.base.BaseController;
import com.hindustries.base.BaseService;
import com.hindustries.dto.request.domain.operasional.inventory.TransaksiInventarisRequest;
import com.hindustries.dto.response.domain.operasional.inventory.TransaksiInventarisResponse;
import com.hindustries.service.domain.operasional.inventory.TransaksiInventarisService;

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