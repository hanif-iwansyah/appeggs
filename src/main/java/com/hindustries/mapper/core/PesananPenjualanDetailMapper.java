package com.hindustries.mapper.core;

import com.hindustries.dto.request.core.PesananPenjualanDetailRequest;
import com.hindustries.dto.response.core.PesananPenjualanDetailResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import java.util.List;

@Mapper(componentModel = "spring")
public interface PesananPenjualanDetailMapper {
    PesananPenjualanDetailResponse toResponse(PesananPenjualanDetailRequest entity);
    List<PesananPenjualanDetailResponse> toResponse(List<PesananPenjualanDetailRequest> lsEntity);
    void updateEntityFromRequest(PesananPenjualanDetailRequest request, @MappingTarget PesananPenjualanDetailRequest entity);
    PesananPenjualanDetailRequest toEntity(PesananPenjualanDetailRequest request);
}
