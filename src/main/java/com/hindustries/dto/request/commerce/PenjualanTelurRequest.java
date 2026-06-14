package com.hindustries.dto.request.commerce;

import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class PenjualanTelurRequest {
    private Long pelangganId;
    private LocalDate tanggalPenjualan;
    private BigDecimal totalHarga;
}
