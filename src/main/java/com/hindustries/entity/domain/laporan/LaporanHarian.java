package com.hindustries.entity.domain.laporan;

import com.hindustries.entity.domain.master.Peternakan;
import com.hindustries.util.Constant;
import com.hindustries.util.ResourceLabel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "laporan_harian")
@ResourceLabel(Constant.LAPORAN_HARIAN)
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