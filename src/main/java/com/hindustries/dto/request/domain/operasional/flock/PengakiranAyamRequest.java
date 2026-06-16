package com.hindustries.dto.request.domain.operasional.flock;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class PengakiranAyamRequest {
    private Long kelompokAyamId;
    private LocalDate tanggalAfkir;
    private Integer jumlahAfkir;
    private String alasanAfkir;
    private String hasilAfkir;
}
