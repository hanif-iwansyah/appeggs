package com.hindustries.mapper.domain.penjualan;

import com.hindustries.dto.request.domain.penjualan.PenjualanTelurDetailRequest;
import com.hindustries.dto.response.domain.penjualan.PenjualanTelurDetailResponse;
import com.hindustries.entity.domain.penjualan.PenjualanTelurDetail;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import java.util.List;

@Mapper(componentModel = "spring")
public interface PenjualanTelurDetailMapper {
    PenjualanTelurDetailResponse toResponse(PenjualanTelurDetail entity);
    List<PenjualanTelurDetailResponse> toResponse(List<PenjualanTelurDetail> lsEntity);
    void updateEntityFromRequest(PenjualanTelurDetailRequest request, @MappingTarget PenjualanTelurDetail entity);
    PenjualanTelurDetail toEntity(PenjualanTelurDetailRequest request);
}
