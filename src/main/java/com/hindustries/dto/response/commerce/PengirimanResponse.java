package com.hindustries.dto.response.commerce;

import com.hindustries.entity.commerce.PesananPenjualan;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PengirimanResponse {
    private PesananPenjualan pesananPenjualan;
    private LocalDate tanggalKirim;
    private String statusPengiriman;
}
