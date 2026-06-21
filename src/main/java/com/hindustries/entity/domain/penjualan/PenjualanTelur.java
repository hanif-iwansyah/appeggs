package com.hindustries.entity.domain.penjualan;

import com.hindustries.entity.domain.master.Pelanggan;
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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pesanan_penjualan_id")
    private PesananPenjualan pesananPenjualan;
    @Column(name = "total_harga")
    private BigDecimal totalHarga;
}
