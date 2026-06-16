package com.hindustries.entity.domain.pembelian;

import com.hindustries.entity.domain.master.Pemasok;
import com.hindustries.util.Constant;
import com.hindustries.util.ResourceLabel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "pesanan_pembelian")
@ResourceLabel(Constant.PESANAN_PEMBELIAN)
public class PesananPembelian {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "pemasok_id", nullable = false)
    private Pemasok pemasok;
    @Column(name = "tanggal_pesanan")
    private LocalDate tanggalPesanan;
}
