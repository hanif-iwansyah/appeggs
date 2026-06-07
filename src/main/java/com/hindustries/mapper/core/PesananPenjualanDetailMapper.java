package com.hindustries.mapper.core;

import com.hindustries.dto.request.core.PesananPenjualanDetailRequest;
import com.hindustries.dto.response.core.PesananPenjualanDetailResponse;
import com.hindustries.entity.core.PesananPenjualanDetail;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import java.util.List;

@Mapper(componentModel = "spring")
public interface PesananPenjualanDetailMapper {
    PesananPenjualanDetailResponse toResponse(PesananPenjualanDetail entity);
    List<PesananPenjualanDetailResponse> toResponse(List<PesananPenjualanDetail> lsEntity);
    void updateEntityFromRequest(PesananPenjualanDetailRequest request, @MappingTarget PesananPenjualanDetail entity);
    PesananPenjualanDetail toEntity(PesananPenjualanDetailRequest request);
}
