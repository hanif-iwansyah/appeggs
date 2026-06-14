package com.hindustries.repository;

import com.hindustries.entity.master.Karyawan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KaryawanRepository extends JpaRepository<Karyawan, Long> {}
