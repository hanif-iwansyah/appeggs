package com.hindustries.dto.response.domain.operasional.inventory;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StokTelurResponse {
    private String gradeTelur;
    private Integer jumlah;
    private String namaGudang;
}