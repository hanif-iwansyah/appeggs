package com.hindustries.dto.response.domain.operasional.flock;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PengakiranKelompokRingkasanResponse {
    private Long kelompokAyamId;
    private String namaKelompok;
    private Integer populasiAwal;
    private Integer totalAfkir;
    private Double persentaseAfkir;
}
