package com.hindustries.entity.domain.pembelian;

import com.hindustries.entity.domain.master.Pemasok;
import com.hindustries.entity.domain.operasional.inventory.StatusPembelianPakan;
import com.hindustries.util.Constant;
import com.hindustries.util.ResourceLabel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "pembelian_pakan")
@ResourceLabel(Constant.PEMBELIAN_PAKAN)
public class PembelianPakan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "pemasok_id", nullable = false)
    private Pemasok pemasok;
    @Column(name = "tanggal_pembelian")
    private LocalDate tanggalPembelian;
    @Column(name = "total_biaya")
    private BigDecimal total_biaya;
    @Enumerated(EnumType.STRING)
    @Column(name = "status_pembelian")
    private StatusPembelianPakan statusPembelian = StatusPembelianPakan.DRFT;
    @OneToMany(mappedBy = "pembelianPakan", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PembelianPakanDetail> details;
}
