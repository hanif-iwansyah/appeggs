package com.hindustries.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "jenis_pakan")
@Getter
@Setter
public class JenisPakan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nama_pakan")
    private String namaPakan;
    @Column(name = "protein_persen")
    private String proteinPersen;
    @Column(name = "energi_kalori")
    private int energiKalori;
}
