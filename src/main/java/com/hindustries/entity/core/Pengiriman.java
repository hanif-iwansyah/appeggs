package com.hindustries.entity.core;

import com.hindustries.util.Constant;
import com.hindustries.util.ResourceLabel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "pengiriman")
@ResourceLabel(Constant.PENGIRIMAN)
public class Pengiriman {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "pesanan_penjualan_id", nullable = false)
    private PesananPenjualan pesananPenjualan;
    @Column(name = "tanggal_kirim")
    private LocalDate tanggalKirim;
    @Column(name = "status_pengiriman")
    private String statusPengiriman;
}
