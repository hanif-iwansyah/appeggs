package com.hindustries.dto.response.inventory;

import com.hindustries.entity.inventory.BarangInventaris;
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
