package com.hindustries.dto.response.farm;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class ProduksiResponse {
    private Long kelompokAyamId;
    private String namaKelompok;
    private LocalDate tanggal;
    private Integer jumlahTelur;
    private Integer telurBaik;
    private Integer telurRetak;
    private Integer telurKecil;
}