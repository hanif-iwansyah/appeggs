package com.hindustries.repository.domain.operasional.inventory;

import com.hindustries.entity.domain.operasional.inventory.StokPakan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import java.util.Optional;

public interface StokPakanRepository extends JpaRepository<StokPakan, Long> {
    Optional<StokPakan> findByJenisPakan_IdAndGudang_Id(Long jenisPakanId, Long gudangId);
    @Query("""
             SELECT s FROM StokPakan s
             WHERE s.stokMinimumKg IS NOT NULL
               AND s.jumlahKg < s.stokMinimumKg
             ORDER BY s.jumlahKg ASC
            """)
    List<StokPakan> findBelowMinimum();
}
