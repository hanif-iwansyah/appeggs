package com.hindustries.dto.response.domain.operasional.flock;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class KematianAyamResponse {
    private String namaKelompokAyam;
    private String namaPenyakit;
    private LocalDate tanggalKasus;
    private int jumlahTerkena;
}
