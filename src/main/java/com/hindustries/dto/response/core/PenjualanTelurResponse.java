package com.hindustries.dto.response.core;

import com.hindustries.entity.Pelanggan;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class PenjualanTelurResponse {
    private Pelanggan pelanggan;
    private LocalDate tanggalPenjualan;
    private BigDecimal totalHarga;
}
