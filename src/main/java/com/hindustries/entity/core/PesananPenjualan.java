package com.hindustries.entity.core;

import com.hindustries.entity.Pelanggan;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "pesanan_penjualan")
@Getter
@Setter
public class PesananPenjualan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "pelanggan_id", nullable = false)
    private Pelanggan pelanggan;
    @Column(name = "tanggal_pesanan")
    private LocalDate tanggalPesanan;
    @Column(name = "total_harga")
    private BigDecimal totalHarga;
}
