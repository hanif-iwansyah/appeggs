package com.hindustries.dto.request.domain.operasional.inventory;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StokObatRequest {
    @NotNull
    private String namaObat;
    @NotNull
    private Long gudangId;
    @Min(1)
    private int jumlah;
}
