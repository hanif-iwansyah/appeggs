package com.hindustries.dto.response.farm;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class ProduksiHarianResponse {
    private LocalDate tanggal;
    private Integer totalProduksi;
    private Integer telurBaik;
    private Integer telurRetak;
    private Integer telurKecil;
}
