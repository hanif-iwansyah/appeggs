package com.hindustries.dto.response.core;

import com.hindustries.entity.master.Pemasok;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PesananPembelianResponse {
    private Pemasok pemasok;
    private LocalDate tanggalPesanan;
}
