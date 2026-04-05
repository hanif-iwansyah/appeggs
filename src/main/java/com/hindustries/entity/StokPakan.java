package com.hindustries.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Entity
@Table(name = "stok_pakan")
@Getter
@Setter
public class StokPakan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "jumlah_kg")
    private BigDecimal jumlahKg;
    @ManyToOne //(fetch = FetchType.LAZY)
    @JoinColumn(name = "jenis_pakan_id", nullable = false)
    private JenisPakan jenisPakan;
    @ManyToOne //(fetch = FetchType.LAZY)
    @JoinColumn(name = "gudang_id", nullable = false)
    private Gudang gudang;
}
