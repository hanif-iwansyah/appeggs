package com.hindustries.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ras_ayam")
@Getter
@Setter
public class RasAyam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nama_ras")
    private String namaRas;
    @Column(name = "asal")
    private String asal;
}
