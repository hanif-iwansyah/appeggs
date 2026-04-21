package com.hindustries.entity.core;

import com.hindustries.entity.Pelanggan;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "pesanan_penjualan_detail")
@Getter
@Setter
public class PesananPenjualanDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "pesanan_penjualan_id", nullable = false)
    private PesananPenjualan pesananPenjualan;
    @Column(name = "produk")
    private String produk;
    @Column(name = "jumlah")
    private Integer jumlah;
    @Column(name = "harga")
    private BigDecimal harga;;;
}
