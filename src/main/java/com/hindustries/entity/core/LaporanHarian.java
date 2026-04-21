package com.hindustries.entity.core;

import com.hindustries.entity.Peternakan;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Entity
@Table(name = "laporan_harian")
@Getter
@Setter
public class LaporanHarian {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "peternakan_id", nullable = false)
    private Peternakan peternakan;
    @Column(name = "tanggal_laporan")
    private LocalDate tanggalLaporan;
    @Column(name = "total_telur")
    private Integer totalTelur;
    @Column(name = "total_kematian")
    private Integer totalKematian;
}