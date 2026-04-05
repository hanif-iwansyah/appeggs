package com.hindustries.repository;

import com.hindustries.entity.Karyawan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KaryawanRepository extends JpaRepository<Karyawan, Long> {}
