package com.hindustries.dto.request.domain.operasional.production;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @NotNull(message = "gudangId is required")
    private Long gudangId;
}
