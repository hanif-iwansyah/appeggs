package com.hindustries.dto.request.domain.operasional.health;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class KasusPenyakitRequest {
    private Long kelompokAyamId;
    private String namaPenyakit;
    private LocalDate tanggalKasus;
    private int jumlahTerkena;
}
