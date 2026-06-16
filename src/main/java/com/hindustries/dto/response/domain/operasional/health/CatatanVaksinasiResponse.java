package com.hindustries.dto.response.domain.operasional.health;

import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class CatatanVaksinasiResponse {
    private String namaKelompokAyam;
    private String jenisPakan;
    private LocalDate tanggalKonsumsi;
    private BigDecimal jumlahKg;
}
