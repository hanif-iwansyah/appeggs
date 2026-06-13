package com.hindustries.entity;

import com.hindustries.util.Constant;
import com.hindustries.util.ResourceLabel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "stok_obat")
@ResourceLabel(Constant.STOK_OBAT)
public class StokObat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nama_obat")
    private String namaObat;
    @Column(name = "jumlah")
    private int jumlah;
}
