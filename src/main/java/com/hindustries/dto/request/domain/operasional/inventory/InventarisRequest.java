package com.hindustries.dto.request.domain.operasional.inventory;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Getter
@Setter
public class InventarisRequest {
    @NotBlank(message = "Kategori tidak boleh kosong (PAKAN/OBAT/TELUR)")
    private String kategori;
    @NotNull(message = "Target ID stock tidak boleh kosong")
    private Long targetId;
    @NotNull(message = "Jumlah tidak boleh kosong")
    @Positive(message = "Jumlah harus lebih besar dari nol")
    private BigDecimal jumlah;
    private String keterangan;
    // Disini kita tambahkan untuk field yang tidak opsional
    private Long gudangId;
    private String gradeTelur;
}
