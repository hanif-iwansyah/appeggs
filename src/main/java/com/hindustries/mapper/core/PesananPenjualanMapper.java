package com.hindustries.mapper.core;

import com.hindustries.dto.request.core.PesananPenjualanRequest;
import com.hindustries.dto.response.core.PesananPenjualanResponse;
import com.hindustries.entity.core.PesananPenjualan;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import java.util.List;

@Mapper(componentModel = "spring")
public interface PesananPenjualanMapper {
    PesananPenjualanResponse toResponse(PesananPenjualan entity);
    List<PesananPenjualanResponse> toResponse(List<PesananPenjualan> lsEntity);
    void updateEntityFromRequest(PesananPenjualanRequest request, @MappingTarget PesananPenjualan entity);
    PesananPenjualan toEntity(PesananPenjualanRequest request);
}
