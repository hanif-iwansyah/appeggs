package com.hindustries.entity.master;

import com.hindustries.util.Constant;
import com.hindustries.util.ResourceLabel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "pelanggan")
@ResourceLabel(Constant.PELANGGAN)
public class Pelanggan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nama_pelanggan")
    private String namaPelanggan;
    @Column(name = "alamat")
    private String alamat;
    @Column(name = "nomor_telepon")
    private String nomorTelepon;
}
