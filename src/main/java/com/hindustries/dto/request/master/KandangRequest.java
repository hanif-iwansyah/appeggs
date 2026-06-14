package com.hindustries.dto.request.master;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class KandangRequest {
    @NotBlank
    private Long peternakanId;
    @NotBlank
    private String namaKandang;
    @NotBlank
    private int kapasitas;
    private Boolean kontrolSuhu;
    private Timestamp dibuatPada;
}