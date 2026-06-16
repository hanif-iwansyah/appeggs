package com.hindustries.dto.request.domain.master;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PelangganRequest {
    @NotBlank
    private String namaPelanggan;
    @NotBlank
    private String alamat;
    @NotBlank
    private String nomorTelepon;
}
