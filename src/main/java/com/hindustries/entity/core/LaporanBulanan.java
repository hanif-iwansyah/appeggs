package com.hindustries.entity.core;

import com.hindustries.entity.Peternakan;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "laporan_bulanan")
@Getter
@Setter
public class LaporanBulanan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "peternakan_id", nullable = false)
    private Peternakan peternakan;
    @Column(name = "bulan")
    private Integer bulan;
    @Column(name = "tahun")
    private Integer tahun;
    @Column(name = "total_telur")
    private Integer totalTelur;
}
