package com.hindustries.dto.request.farm;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class ProduksiRequest {
    private Long kelompokAyamId;
    private LocalDate tanggal;
    private Integer jumlahTelur;
    private Integer telurBaik;
    private Integer telurRetak;
    private Integer telurKecil;
    private Integer totalKematian;
}
