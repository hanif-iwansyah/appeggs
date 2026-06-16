package com.hindustries.repository;

import com.hindustries.entity.farm.PengakiranAyam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface PengakiranAyamRepository extends JpaRepository<PengakiranAyam, Long> {
    List<PengakiranAyam> findAllByKelompokAyamId(Long kelompokId);
    @Query("""
            select coalesce(sum(p.jumlahAfkir), 0) from PengakiranAyam p
           """)
    Integer totalAyamAfkir();
    @Query("""
            select coalesce(sum(p.jumlahAfkir), 0) from PengakiranAyam p where p.kelompokAyam.id = :kelompokId
           """)
    Integer totalAfkirByKelompok(Long kelompokId);

}
