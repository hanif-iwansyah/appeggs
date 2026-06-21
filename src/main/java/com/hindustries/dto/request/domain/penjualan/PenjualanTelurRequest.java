package com.hindustries.dto.request.domain.penjualan;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class PenjualanTelurRequest {
    private Long pelangganId;
    private LocalDate tanggalPenjualan;
    @NotNull(message = "pesananPenjualanId is required")
    private Long pesananPenjualanId;
    private Long gudangId;
    private BigDecimal totalHarga;
}
