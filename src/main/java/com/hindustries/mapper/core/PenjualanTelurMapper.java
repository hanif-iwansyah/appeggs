package com.hindustries.mapper.core;

import com.hindustries.dto.request.core.PenjualanTelurRequest;
import com.hindustries.dto.response.core.PenjualanTelurResponse;
import com.hindustries.entity.core.PenjualanTelur;
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
