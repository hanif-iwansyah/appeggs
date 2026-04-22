package com.hindustries.dto.response.core;

import com.hindustries.entity.core.PembelianPakan;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class PembelianPakanResponse {
    private PembelianPakan pembelianPakan;
    private Long jenisPakanId;
    private BigDecimal jumlahKg;
}
