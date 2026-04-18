package com.hindustries.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "konsumsi_pakan")
@Getter
@Setter
public class KonsumsiPakan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "kelompok_ayam_id", nullable = false)
    private KelompokAyam kelompokAyam;
    @ManyToOne
    @JoinColumn(name = "jenis_pakan_id", nullable = false)
    private JenisPakan jenisPakan;
    @Column(name = "tanggal_konsumsi")
    private LocalDate tanggalKonsumsi;
    @Column(name = "jumlah_kg")
    private BigDecimal jumlahKg;
}
