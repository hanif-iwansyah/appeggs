package com.hindustries.dto.request.domain.penjualan;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class PengirimanRequest {
    private Long pesananPenjualanId;
    private LocalDate tanggalKirim;
    private String statusPengiriman;
}
