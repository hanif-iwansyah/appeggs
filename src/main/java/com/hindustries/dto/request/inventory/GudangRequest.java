package com.hindustries.dto.request.inventory;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GudangRequest {
    @NotBlank
    private String namaGudang;
    @NotBlank
    private String lokasi;
}
