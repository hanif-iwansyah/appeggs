package com.hindustries.entity.core;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Entity
@Table(name = "pengiriman")
@Getter
@Setter
public class Pengiriman {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "pesanan_penjualan_id", nullable = false)
    private PesananPenjualan pesananPenjualan;
    @Column(name = "tanggal_kirim")
    private LocalDate tanggalKirim;
    @Column(name = "status_pengiriman")
    private String statusPengiriman;
}
