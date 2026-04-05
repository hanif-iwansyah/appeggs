package com.hindustries.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PenggunaRequest {
    @NotBlank
    private String namaPengguna;
    @NotBlank
    private String kataSandi;
    @NotBlank
    private Long peranId;
}
