package com.hindustries.entity.domain.master;

import com.hindustries.entity.domain.operasional.inventory.StokPakan;
import com.hindustries.util.Constant;
import com.hindustries.util.ResourceLabel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "gudang")
@ResourceLabel(Constant.GUDANG)
public class Gudang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nama_gudang")
    private String namaGudang;
    @Column(name = "lokasi")
    private String lokasi;
    @OneToMany(mappedBy = "gudang")
    private List<StokPakan> stokList;
}
