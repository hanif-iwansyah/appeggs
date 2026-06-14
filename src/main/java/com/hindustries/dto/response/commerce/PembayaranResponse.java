package com.hindustries.dto.response.commerce;

import com.hindustries.entity.commerce.PesananPenjualan;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class PembayaranResponse {
    private PesananPenjualan pesananPenjualan;
    private BigDecimal jumlahPembayaran;
    private String metodePembayaran;
    private LocalDate tanggalPembayaran;
}

