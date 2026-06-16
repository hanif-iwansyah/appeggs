package com.hindustries.dto.request.domain.operasional.health;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class CatatanVaksinasiRequest {
    private Long kelompokAyamId;
    private Long jadwalVaksinId;
    private LocalDate tanggalVaksin;
}
