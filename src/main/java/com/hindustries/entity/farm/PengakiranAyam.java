package com.hindustries.entity.farm;

import com.hindustries.util.Constant;
import com.hindustries.util.ResourceLabel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "pengakiran_ayam")
@ResourceLabel(Constant.PENGAKIRAN_AYAM)
public class PengakiranAyam {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "kelompok_ayam_id", nullable = false)
    private KelompokAyam kelompokAyam;
    @Column(name = "tanggal_afkir")
    private LocalDate tanggalAfkir;
    @Column(name = "jumlah_afkir")
    private Integer jumlahAfkir;
    @Enumerated(EnumType.STRING)
    @Column(name = "alasan_afkir")
    private AlasanAfkir alasanAfkir;
    @Column(name = "hasil_afkir")
    private String hasilAfkir;
}
