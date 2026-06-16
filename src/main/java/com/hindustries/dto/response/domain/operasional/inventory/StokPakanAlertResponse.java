package com.hindustries.dto.response.domain.operasional.inventory;

import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Getter
@Setter
public class StokPakanAlertResponse {
    private Long id;
    private String namaPakan;
    private String namaGudang;
    private BigDecimal jumlahKg;
    private BigDecimal stokMinimumKg;
    private BigDecimal selisihKg;
}
