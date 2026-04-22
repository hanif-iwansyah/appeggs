package com.hindustries.dto.response.core;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LaporanBulananResponse {
    private String namaPeternakan;
    private Integer bulan;
    private Integer tahun;
    private Integer totalTelur;
}
