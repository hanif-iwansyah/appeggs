package com.hindustries.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "barang_inventaris")
@Getter
@Setter
public class BarangInventaris {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nama_barang")
    private String namaBarang;
    @Column(name = "kategori")
    private String kategori;
}