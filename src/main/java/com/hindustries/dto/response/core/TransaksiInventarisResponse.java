package com.hindustries.dto.response.core;

import com.hindustries.entity.BarangInventaris;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TransaksiInventarisResponse {
    private BarangInventaris barangInventaris;
    private String jenisTransaksi;
    private Integer jumlah;
    private LocalDate tanggalTransaksi;
}
