package com.hindustries.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Entity
@Table(name = "kelompok_ayam")
@Getter
@Setter
public class KelompokAyam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JoinColumn(name = "kandang_id", nullable = false)
    private int kandangId;
    @JoinColumn(name = "ras_id", nullable = false)
    private int rasId;
    @Column(name = "nama_kelompok")
    private String namaKelompok;
    @Column(name = "tanggal_mulai")
    private Date tanggalMulai;
    @Column(name = "populasi_awal")
    private int populasiAwal;
}

//id bigserial primary key,
//kandang_id bigint references kandang(id),
//ras_id bigint references ras_ayam(id),
//nama_kelompok varchar(150),
//tanggal_mulai date,
//populasi_awal integer
