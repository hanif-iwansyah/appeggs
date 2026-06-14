package com.hindustries.dto.request.inventory;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StokObatRequest {
    @NotBlank
    private String namaObat;
    @NotBlank
    private int jumlah;
}
