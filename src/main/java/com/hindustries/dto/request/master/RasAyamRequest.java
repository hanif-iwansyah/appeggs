package com.hindustries.dto.request.master;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RasAyamRequest {
    @NotBlank
    private String namaRas;
    @NotBlank
    private String asal;
}
