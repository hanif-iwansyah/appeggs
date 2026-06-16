package com.hindustries.dto.response.domain.operasional.flock;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
public class KelompokAyamResponse {
    private String namaKandang;
    private String namaRas;
    private String namaKelompok;
    private Date tanggalMulai;
    private int populasiAwal;
}
