package com.hindustries.dto.response.core;

import com.hindustries.entity.Pemasok;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class PembelianPakanRequest {
    private Pemasok pemasok;
    private LocalDate tanggalPembelian;
    private BigDecimal total_biaya;
}
