package com.hindustries.service.domain.operasional.inventory;

import java.math.BigDecimal;

public interface InventarisStrategy {
    boolean isSupported(String kategori);
    void prosesMasuk(Long targetId, BigDecimal jumlah, String keterangan);
    void prosesKeluar(Long targetId, BigDecimal jumlah, String keterangan);
}
