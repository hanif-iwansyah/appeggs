package com.hindustries.controller.domain.penjualan;

import com.hindustries.base.BaseController;
import com.hindustries.base.BaseService;
import com.hindustries.dto.request.domain.pembelian.PembayaranRequest;
import com.hindustries.dto.response.domain.pembelian.PembayaranResponse;
import com.hindustries.service.domain.pembelian.PembayaranService;

/*@RestController
@RequestMapping("/api/pembayaran")*/
public class PembayaranController extends BaseController<PembayaranRequest, PembayaranResponse, Long> {
    private final PembayaranService service;
    public PembayaranController(PembayaranService service) {
        this.service = service;
    }
    @Override
    protected BaseService<PembayaranRequest, PembayaranResponse, Long> getService() {
        return service;
    }
}
