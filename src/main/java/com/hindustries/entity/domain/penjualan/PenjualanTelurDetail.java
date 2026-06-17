package com.hindustries.entity.domain.penjualan;

import com.hindustries.util.Constant;
import com.hindustries.util.ResourceLabel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "penjualan_telur_detail")
@ResourceLabel(Constant.DETAIL_PENJUALAN_TELUR)
public class PenjualanTelurDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "penjualan_telur_id", nullable = false)
    private PenjualanTelur penjualanTelur;
    @Column(name = "grade_telur")
    private String gradeTelur;
    @Column(name = "jumlah")
    private Integer jumlah;
    @Column(name = "harga")
    private BigDecimal harga;
}
