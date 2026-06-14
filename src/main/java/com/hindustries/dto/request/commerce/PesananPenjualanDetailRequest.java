package com.hindustries.dto.request.commerce;

import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Getter
@Setter
public class PesananPenjualanDetailRequest {
    private Long pesananPenjualanId;
    private String produk;
    private Integer jumlah;
    private BigDecimal harga;
}
