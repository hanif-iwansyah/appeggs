package com.hindustries.dto.request.core;

import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Getter
@Setter
public class PesananPenjualanDetail {
    private Long pesananPenjualanId;
    private String produk;
    private Integer jumlah;
    private BigDecimal harga;
}
