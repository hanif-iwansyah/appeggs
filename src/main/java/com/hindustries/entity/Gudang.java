package com.hindustries.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Entity
@Table(name = "gudang")
@Getter
@Setter
public class Gudang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nama_gudang")
    private String namaGudang;
    @Column(name = "lokasi")
    private String lokasi;
    @OneToMany(mappedBy = "gudang")
    private List<StokPakan> stokList;
}
