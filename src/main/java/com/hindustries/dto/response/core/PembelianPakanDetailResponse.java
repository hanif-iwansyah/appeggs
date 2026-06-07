package com.hindustries.dto.response.core;

import com.hindustries.entity.JenisPakan;
import com.hindustries.entity.core.PembelianPakan;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Getter
@Setter
public class PembelianPakanDetailResponse {
    private PembelianPakan pembelianPakan;
    private JenisPakan jenisPakan;
    private BigDecimal jumlahKg;
}
