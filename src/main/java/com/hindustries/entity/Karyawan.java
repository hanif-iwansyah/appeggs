package com.hindustries.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "karyawan")
@Getter
@Setter
public class Karyawan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nama_karyawan")
    private String namaKaryawan;
    @Column(name = "jabatan")
    private String jabatan;
    @Column(name = "nomor_hp")
    private String nomorHp;
}
