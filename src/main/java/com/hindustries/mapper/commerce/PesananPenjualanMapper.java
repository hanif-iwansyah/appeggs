package com.hindustries.mapper.commerce;

import com.hindustries.dto.request.commerce.PesananPenjualanRequest;
import com.hindustries.dto.response.commerce.PesananPenjualanResponse;
import com.hindustries.entity.commerce.PesananPenjualan;
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
