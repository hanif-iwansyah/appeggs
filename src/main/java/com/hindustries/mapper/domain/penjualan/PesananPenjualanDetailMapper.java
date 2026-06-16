package com.hindustries.mapper.domain.penjualan;

import com.hindustries.dto.request.domain.penjualan.PesananPenjualanDetailRequest;
import com.hindustries.dto.response.domain.penjualan.PesananPenjualanDetailResponse;
import com.hindustries.entity.domain.penjualan.PesananPenjualanDetail;
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
