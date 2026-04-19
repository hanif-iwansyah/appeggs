package com.hindustries.dto.response;

import com.hindustries.entity.JenisPakan;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class KonsumsiPakanResponse {
    private String namaKelompokAyam;
    private JenisPakan jenisPakan;
    private LocalDate tanggalKonsumsi;
    private BigDecimal jumlahKg;
}
