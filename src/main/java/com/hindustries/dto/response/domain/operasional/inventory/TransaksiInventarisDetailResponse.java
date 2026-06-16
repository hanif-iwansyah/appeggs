package com.hindustries.dto.response.domain.operasional.inventory;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class TransaksiInventarisDetailResponse {
    private Long id;
    private String jenisTransaksi;
    private Integer jumlah;
    private LocalDate tanggalTransaksi;
    private String keterangan ;
    private Integer runningBalance;
}
