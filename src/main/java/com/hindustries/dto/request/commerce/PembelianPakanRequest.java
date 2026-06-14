package com.hindustries.dto.request.commerce;

import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class PembelianPakanRequest {
    private Long pemasokId;
    private LocalDate tanggalPembelian;
    private BigDecimal total_biaya;
}
