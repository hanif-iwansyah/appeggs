package com.hindustries.dto.response.domain.pembelian;

import com.hindustries.entity.domain.master.Pemasok;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PesananPembelianResponse {
    private Pemasok pemasok;
    private LocalDate tanggalPesanan;
}
