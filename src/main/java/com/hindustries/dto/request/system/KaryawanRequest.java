package com.hindustries.dto.request.system;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KaryawanRequest {
    @NotBlank
    private String namaKaryawan;
    @NotBlank
    private String jabatan;
    @NotBlank
    private String nomorHp;
}
