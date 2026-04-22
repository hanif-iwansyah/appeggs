package com.hindustries.dto.request.core;

simport lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class PesananPembelianRequest {
    private Long pemasokId;
    private LocalDate tanggalPesanan;
}
