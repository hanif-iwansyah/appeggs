package com.hindustries.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Entity
@Table(name = "kematian_ayam")
@Getter
@Setter
public class KematianAyam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @ManyToOne
    @JoinColumn(name = "kelompok_ayam_id", nullable = false)
    private KelompokAyam kelompokAyam;
    @Column(name = "nama_penyakit")
    private String namaPenyakit;
    @Column(name = "tanggal_kasus")
    private LocalDate tanggalKasus;
    @Column(name = "jumlah_terkena")
    private int jumlahTerkena;
}
