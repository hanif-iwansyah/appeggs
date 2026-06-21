package com.hindustries.dto.response.domain.penjualan;

import java.math.BigDecimal;
import java.time.LocalDate;

public class OutstandingPembayaranResponse {
    private Long pesananPenjualanId;
    private String namaPelanggan;
    private LocalDate tanggalPesanan;
    private BigDecimal totalHarga;
    private BigDecimal totalDibayar;
    private BigDecimal sisaTagihan;

    public OutstandingPembayaranResponse(Long pesananPenjualanId, String namaPelanggan,
                                         LocalDate tanggalPesanan, BigDecimal totalHarga,
                                         BigDecimal totalDibayar, BigDecimal sisaTagihan
    ) {
        this.pesananPenjualanId = pesananPenjualanId;
        this.namaPelanggan = namaPelanggan;
        this.tanggalPesanan = tanggalPesanan;
        this.totalHarga = totalHarga;
        this.totalDibayar = totalDibayar;
        this.sisaTagihan = sisaTagihan;
    }
}
