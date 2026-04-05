package com.hindustries.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StokTelurRequest {
    @NotBlank
    private String gradeTelur;
    @NotBlank
    private Integer jumlah;
    @NotBlank
    private Long gudangId;
}