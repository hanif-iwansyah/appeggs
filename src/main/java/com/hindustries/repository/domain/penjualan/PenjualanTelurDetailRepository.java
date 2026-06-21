package com.hindustries.repository.domain.penjualan;

import com.hindustries.entity.domain.penjualan.PenjualanTelurDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PenjualanTelurDetailRepository extends JpaRepository<PenjualanTelurDetail, Long> {
    List<PenjualanTelurDetail> findByPenjualanTelur_Id(Long penjualanTelurId);
}
