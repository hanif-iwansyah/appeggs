package com.hindustries.entity.inventory;

import com.hindustries.entity.master.JenisPakan;
import com.hindustries.util.Constant;
import com.hindustries.util.ResourceLabel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table(name = "stok_pakan")
@ResourceLabel(Constant.STOK_PAKAN)
public class StokPakan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "jumlah_kg")
    private BigDecimal jumlahKg;
    @ManyToOne //(fetch = FetchType.LAZY)
    @JoinColumn(name = "jenis_pakan_id", nullable = false)
    private JenisPakan jenisPakan;
    @ManyToOne //(fetch = FetchType.LAZY)
    @JoinColumn(name = "gudang_id", nullable = false)
    private Gudang gudang;
}
