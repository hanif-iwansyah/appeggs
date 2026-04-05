package com.hindustries.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;

@Entity
@Table(name = "kandang")
@Getter
@Setter
public class Kandang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "peternakan_id", nullable = false)
    private Peternakan peternakan;
    @Column(name = "nama_kandang")
    private String namaKandang;
    @Column(name = "kapasitas")
    private int kapasitas;
    @Column(name = "kontrol_suhu", columnDefinition = "false")
    private Boolean kontrolSuhu;
    @Column(name = "dibuat_pada")
    private Timestamp dibuatPada;
}
