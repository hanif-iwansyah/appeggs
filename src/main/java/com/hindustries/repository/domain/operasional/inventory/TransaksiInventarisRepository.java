package com.hindustries.repository.domain.operasional.inventory;

import com.hindustries.entity.domain.operasional.inventory.TransaksiInventaris;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransaksiInventarisRepository extends JpaRepository<TransaksiInventaris, Long> {
    List<TransaksiInventaris> findByBarangInventaris_IdOrderByTanggalTransaksiAsc(Long barangId);
}
