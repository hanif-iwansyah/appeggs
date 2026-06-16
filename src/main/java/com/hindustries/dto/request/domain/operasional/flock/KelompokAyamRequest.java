package com.hindustries.dto.request.domain.operasional.flock;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
public class KelompokAyamRequest {
    private Long kandangId;
    private Long rasId;
    private String namaKelompok;
    private Date tanggalMulai;
    private int populasiAwal;
}
