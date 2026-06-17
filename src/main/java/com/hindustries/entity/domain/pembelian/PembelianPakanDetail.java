package com.hindustries.entity.domain.pembelian;

import com.hindustries.entity.domain.master.JenisPakan;
import com.hindustries.util.Constant;
import com.hindustries.util.ResourceLabel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "pembelian_pakan_detail")
@ResourceLabel(Constant.PEMBELIAN_PAKAN_DETAIL)
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
    @Column(name = "gudang_tujuan_id")
    private Long gudangTujuanId;
}
