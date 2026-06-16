package com.hindustries.repository.domain.pembelian;

import com.hindustries.entity.domain.pembelian.Pembayaran;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PembayaranRepository extends JpaRepository<Pembayaran, Long> {
}
