package com.hindustries.dto.request.domain.operasional.inventory;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Getter
@Setter
public class StokPakanRequest {
    @NotBlank
    private BigDecimal jumlahKg;
    @NotBlank
    private Long jenisPakanId;
    @NotBlank
    private Long gudangId;
    @NotBlank
    private BigDecimal stokMinimumKg;
}