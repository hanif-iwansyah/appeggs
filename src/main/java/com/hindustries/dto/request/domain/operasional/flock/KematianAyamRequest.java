package com.hindustries.dto.request.domain.operasional.flock;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class KematianAyamRequest {
    private Long kelompokAyamId;
    private String namaPenyakit;
    private LocalDate tanggalKasus;
    private int jumlahTerkena;
}
