package com.hindustries.dto.response.master;

import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;

@Getter
@Setter
public class KandangResponse {
    private String namaPeternakan;
    private String namaKandang;
    private int kapasitas;
    private Boolean kontrolSuhu;
    private Timestamp dibuatPada;
}
