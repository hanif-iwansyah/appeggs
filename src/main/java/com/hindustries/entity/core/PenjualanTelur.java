package com.hindustries.entity.core;

import com.hindustries.entity.Pelanggan;
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
@Table(name = "penjualan_telur")
@ResourceLabel(Constant.PENJUALAN_TELUR)
public class PenjualanTelur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "pelanggan_id", nullable = false)
    private Pelanggan Pelanggan;
    @Column(name = "tanggal_penjualan")
    private LocalDate tanggalPenjualan;
    @Column(name = "total_harga")
    private BigDecimal totalHarga;
}
