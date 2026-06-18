package com.hindustries.dto.response.domain.penjualan;

import com.hindustries.entity.domain.master.Pelanggan;
import com.hindustries.entity.domain.penjualan.StatusPesananPenjualan;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class PesananPenjualanResponse {
    private Pelanggan pelanggan;
    private String namaPelanggan;
    private LocalDate tanggalPesanan;
    private BigDecimal totalHarga;
    private StatusPesananPenjualan statusPesanan;
}
