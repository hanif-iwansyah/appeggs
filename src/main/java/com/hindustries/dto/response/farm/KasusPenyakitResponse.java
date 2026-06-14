package com.hindustries.dto.response.farm;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class KasusPenyakitResponse {
    private String namaKelompok;
    private String namaPenyakit;
    private LocalDate tanggalKasus;
    private int jumlahTerkena;
}
