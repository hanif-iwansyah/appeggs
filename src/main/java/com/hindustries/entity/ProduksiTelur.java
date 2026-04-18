package com.hindustries.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "produksi_telur")
@Getter
@Setter
public class ProduksiTelur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "kelompok_ayam_id")
    private KelompokAyam kelompokAyam;
    @Column(name = "tanggal_produksi")
    private LocalDate tanggalProduksi;
    @Column(name = "total_telur")
    private int totalTelur;
    @Column(name = "telur_pecah")
    private int telurPecah;
    @Column(name = "telur_abnormal")
    private int telurAbnormal;
}