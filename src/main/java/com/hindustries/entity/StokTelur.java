package com.hindustries.entity;

import com.hindustries.util.Constant;
import com.hindustries.util.ResourceLabel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "stok_telur")
@ResourceLabel(Constant.STOK_TELUR)
public class StokTelur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "grade_telur", length = 20, nullable = false)
    private String gradeTelur;
    @Column(name = "jumlah")
    private Integer jumlah;
    @ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name = "gudang_id", nullable = false)
    private Gudang gudang;
}
