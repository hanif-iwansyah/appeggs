package com.hindustries.dto.response.domain.penjualan;

import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class PenjualanTelurResponse {
    private Long pelangganId;
    private String namaPelanggan;
    private BigDecimal totalHarga;
    private LocalDate tanggalPenjualan;
}
