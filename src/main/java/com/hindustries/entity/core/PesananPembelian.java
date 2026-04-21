package com.hindustries.entity.core;

import com.hindustries.entity.Pemasok;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Entity
@Table(name = "pesanan_pembelian")
@Getter
@Setter
public class PesananPembelian {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "pemasok_id", nullable = false)
    private Pemasok pemasok;
    @Column(name = "tanggal_pesanan")
    private LocalDate tanggalPesanan;
}
