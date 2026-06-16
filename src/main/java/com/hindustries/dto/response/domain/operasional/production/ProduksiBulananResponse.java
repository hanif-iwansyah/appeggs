package com.hindustries.dto.response.domain.operasional.production;

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
