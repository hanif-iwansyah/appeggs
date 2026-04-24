package com.hindustries.mapper.core;

import com.hindustries.dto.request.core.LaporanHarianRequest;
import com.hindustries.dto.response.core.LaporanHarianResponse;
import com.hindustries.entity.core.LaporanHarian;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import java.util.List;

@Mapper(componentModel = "spring")
public interface LaporanHarianMapper {
    LaporanHarianResponse toResponse(LaporanHarian entity);
    List<LaporanHarianResponse> toResponse(List<LaporanHarian> lsEntity);
    void updateEntityFromRequest(LaporanHarianRequest request, @MappingTarget LaporanHarian entity);
    LaporanHarian toEntity(LaporanHarianRequest request);
}