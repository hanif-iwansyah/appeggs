package com.hindustries.mapper.domain.penjualan;

import com.hindustries.dto.request.domain.penjualan.PesananPenjualanRequest;
import com.hindustries.dto.response.domain.penjualan.PesananPenjualanResponse;
import com.hindustries.entity.domain.penjualan.PesananPenjualan;
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
