package com.hindustries.entity.domain.master;

import com.hindustries.util.Constant;
import com.hindustries.util.ResourceLabel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "jenis_pakan")
@ResourceLabel(Constant.JENIS_PAKAN)
public class JenisPakan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nama_pakan")
    private String namaPakan;
    @Column(name = "protein_persen")
    private String proteinPersen;
    @Column(name = "energi_kalori")
    private int energiKalori;
}
