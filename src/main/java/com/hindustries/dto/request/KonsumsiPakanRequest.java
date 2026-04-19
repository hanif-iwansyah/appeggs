package com.hindustries.dto.request;

import com.hindustries.entity.JenisPakan;
import java.math.BigDecimal;
import java.time.LocalDate;

public class KonsumsiPakanRequest {
    private Long kelompokAyamId;
    private JenisPakan jenisPakan;
    private LocalDate tanggalKonsumsi;
    private BigDecimal jumlahKg;
}
