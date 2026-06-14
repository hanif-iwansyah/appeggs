package com.hindustries.dto.response.farm;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class ProduksiTelurResponse {
    private String namaKelompokAyam;
    private LocalDate tanggalProduksi;
    private int totalTelur;
    private int telurPecah;
    private int telurAbnormal;
}
