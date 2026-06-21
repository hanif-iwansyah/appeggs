package com.hindustries.repository.domain.penjualan;

import com.hindustries.entity.domain.penjualan.Pembayaran;
import com.hindustries.entity.domain.penjualan.PesananPenjualan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.math.BigDecimal;
import java.util.List;

public interface PembayaranRepository extends JpaRepository<Pembayaran, Long> {
    @Query("SELECT COALESCE(SUM(p.jumlahPembayaran), 0) FROM Pembayaran p WHERE p.pesananPenjualan.id = :pesananId")
    BigDecimal sumByPesananId(@Param("pesananId") Long pesananId);

    @Query("SELECT p FROM PesananPenjualan p " +
            "WHERE p.pelanggan.id = :pelangganId " +
            "AND p.statusPesanan != com.hindustries.entity.domain.penjualan.StatusPesananPenjualan.DIBATALKAN " +
            "AND p.totalHarga > (SELECT COALESCE(SUM(py.jumlahPembayaran), 0) " +
            "FROM Pembayaran py WHERE py.pesananPenjualan.id = p.id)")
    List<PesananPenjualan> findUnpaidByPelangganId(@Param("pelangganId") Long pelangganId);
}
