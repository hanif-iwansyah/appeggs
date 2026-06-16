package com.hindustries.dto.response.domain.operasional.flock;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class KelompokAyamRingkasanResponse {
    private Long id;
    private String namaKelompok;
    private String StatusKelompok;
    private Integer populasiAwal;
    private Integer populasiAktual;
    private long umurHari;
}
