package com.hindustries.dto.response;

import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class PenjualanTelurResponse {
    private Long pelangganId;
    private BigDecimal totalHarga;
    private LocalDateTime tanggalPenjualan;
}
