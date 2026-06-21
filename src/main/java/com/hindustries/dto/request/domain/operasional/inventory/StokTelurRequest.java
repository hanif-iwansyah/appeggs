package com.hindustries.dto.request.domain.operasional.inventory;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StokTelurRequest {
    @NotNull
    private String gradeTelur;
    @Min(1)
    private Integer jumlah;
    @NotNull
    private Long gudangId;
}