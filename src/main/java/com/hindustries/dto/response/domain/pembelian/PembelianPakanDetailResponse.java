package com.hindustries.dto.response.domain.pembelian;

import com.hindustries.entity.domain.master.JenisPakan;
import com.hindustries.entity.domain.pembelian.PembelianPakan;
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
