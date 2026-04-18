package com.hindustries.dto.response;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class GradingTelurResponse {
    private String namaKelompokAyam;
    private LocalDate tanggalProduksi;
    private int gradeA;
    private int gradeB;
    private int gradeC;
}
