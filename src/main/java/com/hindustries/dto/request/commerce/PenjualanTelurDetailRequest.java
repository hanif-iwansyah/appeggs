package com.hindustries.dto.request.commerce;

import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Getter
@Setter
public class PenjualanTelurDetailRequest {
    private Long penjualanTelurId;
    private String gradeTelur;
    private Integer jumlah;
    private BigDecimal harga;
}
