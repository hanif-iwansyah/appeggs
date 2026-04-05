package com.hindustries.dto.response;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class PeternakanResponse {
    private String namaPeternakan;
    private String lokasi;
    private String namaPemilik;
    private LocalDateTime dibuatPada;
}
