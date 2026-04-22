package com.hindustries.dto.response.core;

import com.hindustries.entity.core.PesananPenjualan;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class PesananPenjualanDetailResponse {
    private PesananPenjualan pesananPenjualan;
    private String produk;
    private Integer jumlah;
    private BigDecimal harga;
}
