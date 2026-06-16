package com.hindustries.dto.response.domain.laporan;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class LaporanHarianResponse {
    private String namaPeternakan;
    private LocalDate tanggalLaporan;
    private Integer totalTelur;
    private Integer totalKematian;
}