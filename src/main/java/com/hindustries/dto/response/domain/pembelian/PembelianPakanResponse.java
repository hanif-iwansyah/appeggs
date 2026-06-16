package com.hindustries.dto.response.domain.pembelian;

import com.hindustries.entity.domain.pembelian.PembelianPakan;
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
