package com.hindustries.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "stok_obat")
@Getter
@Setter
public class StokObat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nama_obat")
    private String namaObat;
    @Column(name = "jumlah")
    private int jumlah;
}
