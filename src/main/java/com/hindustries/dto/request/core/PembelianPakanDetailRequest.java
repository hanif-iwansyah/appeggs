package com.hindustries.dto.request.core;

import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Getter
@Setter
public class PembelianPakanDetailRequest {
    private Long pembelianPakanId;
    private Long jenisPakanId;
    private BigDecimal jumlahKg;
}
