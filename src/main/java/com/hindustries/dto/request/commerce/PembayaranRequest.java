package com.hindustries.dto.request.commerce;

import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class PembayaranRequest {
    private Long pesananPenjualanId;
    private BigDecimal jumlahPembayaran;
    private String metodePembayaran;
    private LocalDate tanggalPembayaran;
}

