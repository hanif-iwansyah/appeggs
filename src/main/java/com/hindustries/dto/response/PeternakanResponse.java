package com.hindustries.dto.response;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class PeternakanResponse {
    private String namaPeternakan;
    private String lokasi;
    private String namaPemilik;
    private LocalDateTime dibuatPada;
}
