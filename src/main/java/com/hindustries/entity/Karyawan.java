package com.hindustries.entity;

import com.hindustries.util.Constant;
import com.hindustries.util.ResourceLabel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "karyawan")
@ResourceLabel(Constant.KARYAWAN)
public class Karyawan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nama_karyawan")
    private String namaKaryawan;
    @Column(name = "jabatan")
    private String jabatan;
    @Column(name = "nomor_hp")
    private String nomorHp;
}
