package com.hindustries.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "jadwal_vaksin")
@Getter
@Setter
public class JadwalVaksin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nama_vaksin")
    private String namaVaksin;
    @Column(name = "umur_hari")
    private int umurHari;
}
