package com.hindustries.dto.request.domain.operasional.inventory;

import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class KonsumsiPakanRequest {
    private Long kelompokAyamId;
    private Long jenisPakanId;
    private LocalDate tanggalKonsumsi;
    private BigDecimal jumlahKg;
}
