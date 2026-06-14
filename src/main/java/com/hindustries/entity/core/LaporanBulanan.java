package com.hindustries.entity.core;

import com.hindustries.entity.master.Peternakan;
import com.hindustries.util.Constant;
import com.hindustries.util.ResourceLabel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "laporan_bulanan")
@ResourceLabel(Constant.LAPORAN_BULANAN)
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
