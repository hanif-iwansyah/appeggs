package com.hindustries.mapper.commerce;

import com.hindustries.dto.request.commerce.PenjualanTelurDetailRequest;
import com.hindustries.dto.response.commerce.PenjualanTelurDetailResponse;
import com.hindustries.entity.commerce.PenjualanTelurDetail;
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
