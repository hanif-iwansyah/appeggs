package com.hindustries.entity.core;

import com.hindustries.entity.JenisPakan;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Entity
@Table(name = "pembelian_pakan_detail")
@Getter
@Setter
public class PembelianPakanDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "pembelian_pakan_id", nullable = false)
    private PembelianPakan pembelianPakan;
    @ManyToOne
    @JoinColumn(name = "jenis_pakan_id", nullable = false)
    private JenisPakan jenisPakan;
    @Column(name = "jumlah_kg")
    private BigDecimal jumlahKg;
}
