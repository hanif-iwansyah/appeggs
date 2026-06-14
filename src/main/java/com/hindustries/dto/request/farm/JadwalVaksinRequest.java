package com.hindustries.dto.request.farm;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JadwalVaksinRequest {
    @NotBlank
    private String namaVaksin;
    @NotBlank
    private int umurHari;
}
