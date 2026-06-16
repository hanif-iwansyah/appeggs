package com.hindustries.dto.response.domain.operasional.production;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProduksiTelurSummaryResponse {
    private Long kelompokAyamId;
    private String namaKelompok;
    private Long totalTelur;
    private Long telurPecah;
    private Long telurAbnormal;
    private Long telurValid;

    public ProduksiTelurSummaryResponse(
            Long kelompokAyamId,
            String namaKelompok,
            Long totalTelur,
            Long telurPecah,
            Long telurAbnormal,
            Long telurValid) {
        this.kelompokAyamId = kelompokAyamId;
        this.namaKelompok = namaKelompok;
        this.totalTelur = totalTelur;
        this.telurPecah = telurPecah;
        this.telurAbnormal =telurAbnormal;
        this.telurValid = telurValid;
    }
}
