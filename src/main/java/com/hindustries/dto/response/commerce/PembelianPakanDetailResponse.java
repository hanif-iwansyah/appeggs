package com.hindustries.dto.response.commerce;

import com.hindustries.entity.master.JenisPakan;
import com.hindustries.entity.commerce.PembelianPakan;
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
