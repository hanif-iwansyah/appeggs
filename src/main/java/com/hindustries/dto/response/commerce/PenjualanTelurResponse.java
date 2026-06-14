package com.hindustries.dto.response.commerce;

import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class PenjualanTelurResponse {
    private String namaPelanggan;
    private BigDecimal totalHarga;
    private LocalDate tanggalPenjualan;
}
//@Getter
//@Setter
//public class PenjualanTelurResponse {
//private Pelanggan pelanggan;
//    private String namaPelanggan;
//    private BigDecimal totalHarga;
//    private LocalDateTime tanggalPenjualan;
//}