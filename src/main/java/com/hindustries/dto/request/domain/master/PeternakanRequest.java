package com.hindustries.dto.request.domain.master;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PeternakanRequest {
    @NotBlank
    private String namaPeternakan;
    @NotBlank
    private String lokasi;
    @NotBlank
    private String namaPemilik;
    private LocalDateTime dibuatPada;
}
