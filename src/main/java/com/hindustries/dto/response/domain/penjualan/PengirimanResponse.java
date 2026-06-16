package com.hindustries.dto.response.domain.penjualan;

import com.hindustries.entity.domain.penjualan.PesananPenjualan;
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
