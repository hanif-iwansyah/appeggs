package com.hindustries.entity.core;

import com.hindustries.util.Constant;
import com.hindustries.util.ResourceLabel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "pembayaran")
@ResourceLabel(Constant.PEMBAYARAN)
public class Pembayaran {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "pesanan_penjualan_id", nullable = false)
    private PesananPenjualan pesananPenjualan;
    @Column(name = "jumlah_pembayaran")
    private BigDecimal jumlahPembayaran;
    @Column(name = "metode_pembayaran")
    private String metodePembayaran;
    @Column(name = "tanggal_pembayaran")
    private LocalDate tanggalPembayaran;
}

