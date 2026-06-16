package com.hindustries.dto.request.domain.laporan;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LaporanBulananRequest {
    private Long peternakanId;
    private Integer bulan;
    private Integer tahun;
    private Integer totalTelur;
}
