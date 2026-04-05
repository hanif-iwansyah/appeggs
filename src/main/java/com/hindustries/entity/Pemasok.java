package com.hindustries.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "pemasok")
@Getter
@Setter
public class Pemasok {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nama_pemasok")
    private String namaPemasok;
    @Column(name = "kontak")
    private String kontak;
}
