package com.hindustries.entity;

import com.hindustries.util.Constant;
import com.hindustries.util.ResourceLabel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name = "peternakan")
@Getter
@Setter
@ResourceLabel(Constant.PETERNAKAN)
public class Peternakan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nama_peternakan", nullable = false)
    private String namaPeternakan;
    @Column(name = "lokasi")
    private String lokasi;
    @Column(name = "nama_pemilik")
    private String namaPemilik;
    @Column(name = "dibuat_pada")
    private LocalDateTime dibuatPada;
}
