package com.hindustries.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class ProduksiTelurRequest {
    @NotBlank
    private Long kelompokAyamId;
    @NotBlank
    private LocalDate tanggalProduksi;
    @NotBlank
    private int totalTelur;
    @NotBlank
    private int telurPecah;
    @NotBlank
    private int telurAbnormal;
}
