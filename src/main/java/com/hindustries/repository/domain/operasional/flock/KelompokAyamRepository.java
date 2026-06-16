package com.hindustries.repository.domain.operasional.flock;

import com.hindustries.entity.domain.operasional.flock.KelompokAyam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface KelompokAyamRepository extends JpaRepository<KelompokAyam, Long> {
    @Query(
            "SELECT (k.populasiAwal - COALESCE(SUM(km.jumlahTerkena), 0)) " +
                    "FROM KelompokAyam k " +
                    "LEFT JOIN KematianAyam km ON km.kelompokAyam.id = k.id " +
                    "WHERE k.id = :id " +
                    "GROUP BY k.id, k.populasiAwal")
    Integer findPopulasiAktual(@Param("id") Long id);
}
