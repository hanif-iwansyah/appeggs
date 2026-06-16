package com.hindustries.entity.domain.operasional.inventory;

import com.hindustries.util.Constant;
import com.hindustries.util.ResourceLabel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "barang_inventaris")
@ResourceLabel(Constant.BARANG_INVENTARIS)
public class BarangInventaris {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nama_barang")
    private String namaBarang;
    @Column(name = "kategori")
    private String kategori;
    @Column(name = "stok_awal")
    private Integer stokAwal;
}