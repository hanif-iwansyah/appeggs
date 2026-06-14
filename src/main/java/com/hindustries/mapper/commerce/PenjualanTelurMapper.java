package com.hindustries.mapper.commerce;

import com.hindustries.dto.request.commerce.PenjualanTelurRequest;
import com.hindustries.dto.response.commerce.PenjualanTelurResponse;
import com.hindustries.entity.commerce.PenjualanTelur;
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
