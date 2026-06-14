package com.hindustries.dto.response.commerce;

import com.hindustries.entity.commerce.PenjualanTelur;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class PenjualanTelurDetailResponse {
    private PenjualanTelur penjualanTelur;
    private String gradeTelur;
    private Integer jumlah;
    private BigDecimal harga;
}
