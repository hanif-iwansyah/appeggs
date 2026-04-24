package com.hindustries.mapper.core;

import com.hindustries.dto.request.core.PenjualanTelurDetailRequest;
import com.hindustries.dto.response.core.PenjualanTelurDetailResponse;
import com.hindustries.entity.core.PenjualanTelurDetail;
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
