package com.hindustries.entity.core;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "penjualan_telur_detail")
@Getter
@Setter
public class PenjualanTelurDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "penjualan_telur_id", nullable = false)
    private PenjualanTelur penjualanTelur;
    @Column(name = "grade_telur")
    private String gradeTelur;
    @Column(name = "jumlah")
    private Integer jumlah;
    @Column(name = "harga")
    private BigDecimal harga;
}
