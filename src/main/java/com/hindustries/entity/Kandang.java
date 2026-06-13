package com.hindustries.entity;

import com.hindustries.util.Constant;
import com.hindustries.util.ResourceLabel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "kandang")
@ResourceLabel(Constant.KANDANG)
public class Kandang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne//(fetch = FetchType.LAZY)
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
