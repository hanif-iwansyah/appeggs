package com.hindustries.dto.request.domain.operasional.inventory;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class TransaksiInventarisRequest {
    private Long barangInventarisId;
    private String jenisTransaksi;
    private Integer jumlah;
    private LocalDate tanggalTransaksi;
}
