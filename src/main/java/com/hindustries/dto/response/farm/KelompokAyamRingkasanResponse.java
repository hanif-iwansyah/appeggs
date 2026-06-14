package com.hindustries.dto.response.farm;

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
