package com.hindustries.entity;

import com.hindustries.util.Constant;
import com.hindustries.util.ResourceLabel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "catatan_vaksinasi")
@ResourceLabel(Constant.CATATAN_VAKSINASI)
public class CatatanVaksinasi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "kelompok_ayam_id", nullable = false)
    private KelompokAyam kelompokAyam;
    @ManyToOne
    @JoinColumn(name = "jadwal_vaksin_id", nullable = false)
    private JadwalVaksin jadwalVaksin;
    @Column(name = "tanggal_vaksin")
    private LocalDate tanggalVaksin;
}
