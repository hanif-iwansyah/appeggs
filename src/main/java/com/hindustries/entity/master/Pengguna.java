package com.hindustries.entity.master;

import com.hindustries.util.Constant;
import com.hindustries.util.ResourceLabel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "pengguna")
@ResourceLabel(Constant.PENGGUNA)
public class Pengguna {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nama_pengguna")
    private String namaPengguna;
    @Column(name = "kata_sandi")
    private String kataSandi;
    @ManyToOne
    @JoinColumn(name = "peran_id", nullable = false)
    private Peran peran;
}
