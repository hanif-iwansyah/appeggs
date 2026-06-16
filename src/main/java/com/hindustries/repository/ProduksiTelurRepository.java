package com.hindustries.repository;

import com.hindustries.dto.response.domain.operasional.ProduksiTelurSummaryResponse;
import com.hindustries.entity.farm.ProduksiTelur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    @Query("""
            select coalesce(sum(p.totalTelur - p.telurPecah - p.telurAbnormal), 0) from ProduksiTelur p where p.kelompokAyam.id = :kelompokAyamId and p.tanggalProduksi between :dari and :sampai
           """)
    Integer sumTelurValid(@Param("kelompokAyamId") Long id,
                          @Param("dari") LocalDate dari,
                          @Param("sampai") LocalDate sampai);

    @Query("""
           SELECT new com.hindustries.dto.response.domain.operasional.ProduksiTelurSummaryResponse(
               p.kelompokAyam.id,
               p.kelompokAyam.namaKelompok,
               SUM(p.totalTelur),
               SUM(p.telurPecah),
               SUM(p.telurAbnormal),
               SUM(p.totalTelur - p.telurPecah - p.telurAbnormal)
           )
           FROM ProduksiTelur p
            WHERE p.kelompokAyam.id = :kelompokAyamId
            AND p.tanggalProduksi BETWEEN :dari AND :sampai
            GROUP BY p.kelompokAyam.id, p.kelompokAyam.namaKelompok
           """)
    ProduksiTelurSummaryResponse getSummary(@Param("kelompokAyamId") Long kelompokAyamId,
                                            @Param("dari") LocalDate dari,
                                            @Param("sampai") LocalDate sampai);

}
