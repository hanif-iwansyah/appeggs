package com.hindustries.dto.response.farm;

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
