package com.hindustries.repository.farm;

import com.hindustries.entity.farm.ProduksiTelur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.time.LocalDate;

public interface ProduksiTelurRepository extends JpaRepository<ProduksiTelur, Long> {
    @Query("""
            select coalesce(sum(p.totalTelur), 0) from ProduksiTelur p where p.tanggalProduksi = :tanggal
           """)
    Integer totalProduksiHarian(LocalDate tanggal);
    @Query("""
            select coalesce(sum(p.totalTelur), 0) from ProduksiTelur p where month(p.tanggalProduksi) = :bulan and year(p.tanggalProduksi) = :tahun
           """)
    Integer totalProduksiBulanan(Integer bulan, Integer tahun);
}
