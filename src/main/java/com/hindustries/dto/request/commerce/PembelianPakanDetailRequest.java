package com.hindustries.dto.request.commerce;

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
