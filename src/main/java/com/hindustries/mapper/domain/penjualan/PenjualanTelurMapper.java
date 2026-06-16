package com.hindustries.mapper.domain.penjualan;

import com.hindustries.dto.request.domain.penjualan.PenjualanTelurRequest;
import com.hindustries.dto.response.domain.penjualan.PenjualanTelurResponse;
import com.hindustries.entity.domain.penjualan.PenjualanTelur;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import java.util.List;

@Mapper(componentModel = "spring")
public interface PenjualanTelurMapper {
    PenjualanTelurResponse toResponse(PenjualanTelur entity);
    List<PenjualanTelurResponse> toResponse(List<PenjualanTelur> lsEntity);
    void updateEntityFromRequest(PenjualanTelurRequest request, @MappingTarget PenjualanTelur entity);
    PenjualanTelur toEntity(PenjualanTelurRequest request);
}
