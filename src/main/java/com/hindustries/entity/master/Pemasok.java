package com.hindustries.entity.master;

import com.hindustries.util.Constant;
import com.hindustries.util.ResourceLabel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "pemasok")
@ResourceLabel(Constant.PEMASOK)
public class Pemasok {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nama_pemasok")
    private String namaPemasok;
    @Column(name = "kontak")
    private String kontak;
}
