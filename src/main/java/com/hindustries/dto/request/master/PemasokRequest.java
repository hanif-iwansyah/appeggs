package com.hindustries.dto.request.master;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PemasokRequest {
    @NotBlank
    private String namaPemasok;
    @NotBlank
    private String kontak;
}
