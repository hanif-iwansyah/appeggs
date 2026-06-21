package com.hindustries.dto.request.domain.operasional.inventory;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Getter
@Setter
public class StokPakanRequest {
    @NotNull
    @DecimalMin("0.01")
    private BigDecimal jumlahKg;
    @NotNull
    private Long jenisPakanId;
    @NotNull
    private Long gudangId;
    @Min(1)
    private BigDecimal stokMinimumKg;
}