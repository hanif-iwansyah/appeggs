package com.hindustries.entity.core;

import com.hindustries.entity.Pelanggan;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "penjualan_telur")
@Getter
@Setter
public class PenjualanTelur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "pelanggan_id", nullable = false)
    private Pelanggan Pelanggan;
    @Column(name = "tanggal_penjualan")
    private LocalDate tanggalPenjualan;
    @Column(name = "total_harga")
    private BigDecimal totalHarga;
}
