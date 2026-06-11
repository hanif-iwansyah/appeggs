package com.hindustries.repository;

import com.hindustries.entity.KelompokAyam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface KelompokAyamRepository extends JpaRepository<KelompokAyam, Long> {
    @Query(
            "SELECT k.populasiAwal - COALESCE(SUM(km.jumlahTerkena), 0) " +
                    "FROM KelompokAyam k " +
                    "LEFT JOIN KematianAyam km ON km.kelompokAyam.id = k.id " +
                    "WHERE k.id = :id"
    )
    Integer findPopulasiAktual(@Param("id") Long id);
}
