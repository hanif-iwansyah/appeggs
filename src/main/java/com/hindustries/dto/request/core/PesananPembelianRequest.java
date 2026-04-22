package com.hindustries.dto.request.core;

import com.hindustries.entity.Pemasok;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class PesananPembelianRequest {
    private Long pemasokId;
    private LocalDate tanggalPesanan;
}
