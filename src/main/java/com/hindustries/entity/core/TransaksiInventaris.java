package com.hindustries.entity.core;

import com.hindustries.entity.BarangInventaris;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Entity
@Table(name = "transaksi_inventaris")
@Getter
@Setter
public class TransaksiInventaris {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "barang_inventaris_id", nullable = false)
    private BarangInventaris barangInventaris;
    @Column(name = "jenis_transaksi")
    private String jenisTransaksi;
    @Column(name = "jumlah")
    private Integer jumlah;
    @Column(name = "tanggal_transaksi")
    private LocalDate tanggalTransaksi;
}
