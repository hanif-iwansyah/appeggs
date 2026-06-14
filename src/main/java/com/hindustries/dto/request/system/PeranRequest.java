package com.hindustries.dto.request.system;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PeranRequest {
    @NotBlank
    private String namaPeran;
}
