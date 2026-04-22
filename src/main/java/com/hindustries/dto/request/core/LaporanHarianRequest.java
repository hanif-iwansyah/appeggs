package com.hindustries.dto.request.core;

import com.hindustries.entity.Peternakan;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class LaporanHarianRequest {
    private Long peternakanId;
    private LocalDate tanggalLaporan;
    private Integer totalTelur;
    private Integer totalKematian;
}