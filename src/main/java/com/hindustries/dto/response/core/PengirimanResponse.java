package com.hindustries.dto.response.core;

import com.hindustries.entity.core.PesananPenjualan;
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
