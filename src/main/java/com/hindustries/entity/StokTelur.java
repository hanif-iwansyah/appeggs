package com.hindustries.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "stok_telur")
@Getter
@Setter
public class StokTelur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "grade_telur", length = 20, nullable = false)
    private String gradeTelur;
    @Column(name = "jumlah")
    private Integer jumlah;
    @ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name = "gudang_id", nullable = false)
    private Gudang gudang;
}
