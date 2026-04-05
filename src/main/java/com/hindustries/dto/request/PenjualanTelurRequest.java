package com.hindustries.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class PenjualanTelurRequest {
    @NotBlank
    private Long pelangganId;
    @NotBlank
    private BigDecimal totalHarga;
    private LocalDateTime tanggalPenjualan;
}
