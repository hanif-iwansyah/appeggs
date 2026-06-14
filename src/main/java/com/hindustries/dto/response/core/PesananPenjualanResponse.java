package com.hindustries.dto.response.core;

import com.hindustries.entity.master.Pelanggan;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class PesananPenjualanResponse {
    private Pelanggan pelanggan;
    private LocalDate tanggalPesanan;
    private BigDecimal totalHarga;
}
