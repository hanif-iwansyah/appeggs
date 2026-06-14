package com.hindustries.entity.commerce;

import com.hindustries.entity.master.Pelanggan;
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
@Table(name = "pesanan_penjualan")
@ResourceLabel(Constant.PESANAN_PENJUALAN)
public class PesananPenjualan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "pelanggan_id", nullable = false)
    private Pelanggan pelanggan;
    @Column(name = "tanggal_pesanan")
    private LocalDate tanggalPesanan;
    @Column(name = "total_harga")
    private BigDecimal totalHarga;
}
