package com.hindustries.entity;

import com.hindustries.util.StatusKelompok;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "kelompok_ayam")
@Getter
@Setter
public class KelompokAyam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name = "kandang_id", nullable = false)
    private Kandang kandang;
    @ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name = "ras_id", nullable = false)
    private RasAyam ras;
    @Column(name = "nama_kelompok")
    private String namaKelompok;
    @Column(name = "tanggal_mulai")
    private Date tanggalMulai;
    @Column(name = "populasi_awal")
    private int populasiAwal;
    @OneToMany(mappedBy = "kelompokAyam", cascade = CascadeType.ALL)
    private List<ProduksiTelur> produksiTelurList;
    @Enumerated(EnumType.STRING)
    @Column(name = "status_kelompok")
    private StatusKelompok statusKelompok = StatusKelompok.AKTIF;
}
