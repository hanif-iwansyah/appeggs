package com.hindustries.dto.response.domain.operasional.inventory;

import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class KonsumsiPakanResponse {
    private String namaKelompokAyam;
    private String namaJenisPakan;
    private LocalDate tanggalKonsumsi;
    private BigDecimal jumlahKg;
}
