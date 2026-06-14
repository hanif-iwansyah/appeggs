package com.hindustries.entity.commerce;

import com.hindustries.util.Constant;
import com.hindustries.util.ResourceLabel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "pesanan_penjualan_detail")
@ResourceLabel(Constant.PESANAN_PENJUALAN_DETAIL)
public class PesananPenjualanDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "pesanan_penjualan_id", nullable = false)
    private PesananPenjualan pesananPenjualan;
    @Column(name = "produk")
    private String produk;
    @Column(name = "jumlah")
    private Integer jumlah;
    @Column(name = "harga")
    private BigDecimal harga;;;
}
