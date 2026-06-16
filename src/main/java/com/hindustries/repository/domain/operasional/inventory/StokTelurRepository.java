package com.hindustries.repository.domain.operasional.inventory;

import com.hindustries.entity.domain.operasional.inventory.StokTelur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StokTelurRepository extends JpaRepository<StokTelur, Long> {
    Optional<StokTelur> findByGradeTelurAndGudang_Id(String gradeTelur, Long gudangId);
}
