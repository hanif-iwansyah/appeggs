package com.hindustries.mapper.system;

import com.hindustries.dto.request.system.LaporanHarianRequest;
import com.hindustries.dto.response.system.LaporanHarianResponse;
import com.hindustries.entity.system.LaporanHarian;
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