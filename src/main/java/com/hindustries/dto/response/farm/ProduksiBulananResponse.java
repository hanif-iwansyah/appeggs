package com.hindustries.dto.response.farm;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProduksiBulananResponse {
    private Integer bulan;
    private Integer tahun;
    private Integer totalProduksi;
    private Double rataRataProduksi;
}
