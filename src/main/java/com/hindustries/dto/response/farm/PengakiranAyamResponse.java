package com.hindustries.dto.response.farm;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class PengakiranAyamResponse {
    private LocalDate tanggalAfkir;
    private Integer jumlahAfkir;
    private String alasanAfkir;
    private String hasilAfkir;
}
