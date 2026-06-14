package com.hindustries.mapper.commerce;

import com.hindustries.dto.request.commerce.PesananPenjualanDetailRequest;
import com.hindustries.dto.response.commerce.PesananPenjualanDetailResponse;
import com.hindustries.entity.commerce.PesananPenjualanDetail;
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
