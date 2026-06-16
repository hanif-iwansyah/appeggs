package com.hindustries.entity.domain.operasional.health;

import com.hindustries.util.Constant;
import com.hindustries.util.ResourceLabel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "jadwal_vaksin")
@ResourceLabel(Constant.JADWAL_VAKSIN)
public class JadwalVaksin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nama_vaksin")
    private String namaVaksin;
    @Column(name = "umur_hari")
    private int umurHari;
}
