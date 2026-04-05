package com.hindustries.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JenisPakanRequest {
    @NotBlank
    private String namaPakan;
    @NotBlank
    private String proteinPersen;
    @NotBlank
    private int energiKalori;
}
