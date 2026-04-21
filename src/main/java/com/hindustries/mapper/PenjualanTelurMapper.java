package com.hindustries.mapper;

import com.hindustries.dto.request.PenjualanTelurRequest;
import com.hindustries.dto.response.PenjualanTelurResponse;
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
