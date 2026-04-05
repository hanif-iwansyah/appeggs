package com.hindustries.dto.response;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PenjualanTelurResponse {
    private Long pelangganId;
    private BigDecimal totalHarga;
    private LocalDateTime tanggalPenjualan;
}
