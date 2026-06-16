package com.hindustries.dto.response.domain.operasional.production;

import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class HdpResponse {
    private String namaKelompok;
    private LocalDate dari;
    private LocalDate sampai;
    private Integer totalTelurValid;
    private Integer populasiAktual;
    private BigDecimal hdpPersen;
}
