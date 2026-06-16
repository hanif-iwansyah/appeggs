package com.hindustries.entity.domain.operasional.inventory;

import com.hindustries.util.Constant;
import com.hindustries.util.ResourceLabel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "transaksi_inventaris")
@ResourceLabel(Constant.TRANSAKSI_INVENTARIS)
public class TransaksiInventaris {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "barang_inventaris_id", nullable = false)
    private BarangInventaris barangInventaris;
    @Column(name = "jenis_transaksi")
    private String jenisTransaksi;
    @Column(name = "jumlah")
    private Integer jumlah;
    @Column(name = "tanggal_transaksi")
    private LocalDate tanggalTransaksi;
}
