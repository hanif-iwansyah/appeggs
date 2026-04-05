package com.hindustries.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "pelanggan")
@Getter
@Setter
public class Pelanggan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nama_pelanggan")
    private String namaPelanggan;
    @Column(name = "alamat")
    private String alamat;
    @Column(name = "nomor_telepon")
    private String nomorTelepon;
}
