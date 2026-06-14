package com.hindustries.dto.request.farm;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GradingTelurRequest {
    @NotBlank
    private Long produksiTelurId;
    @NotBlank
    private int gradeA;
    @NotBlank
    private int gradeB;
    @NotBlank
    private int gradeC;
}
