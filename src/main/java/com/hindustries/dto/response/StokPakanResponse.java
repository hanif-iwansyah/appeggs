package com.hindustries.dto.response;

import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Getter
@Setter
public class StokPakanResponse {
    private BigDecimal jumlahKg;
    private String namaPakan;
    private String namaGudang;
}