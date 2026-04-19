package com.hindustries.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "pengguna")
@Setter
@Getter
public class Pengguna {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nama_pengguna")
    private String namaPengguna;
    @Column(name = "kata_sandi")
    private String kataSandi;
    @ManyToOne
    @JoinColumn(name = "peran_id", nullable = false)
    private Peran peran;
}
