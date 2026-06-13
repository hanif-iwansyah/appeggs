package com.hindustries.entity.core;

import com.hindustries.entity.Pemasok;
import com.hindustries.util.Constant;
import com.hindustries.util.ResourceLabel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "pembelian_pakan")
@ResourceLabel(Constant.PEMBELIAN_PAKAN)
public class PembelianPakan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "pemasok_id", nullable = false)
    private Pemasok pemasok;
    @Column(name = "tanggal_pembelian")
    private LocalDate tanggalPembelian;
    @Column(name = "total_biaya")
    private BigDecimal total_biaya;
}
