package com.hindustries.mapper.domain.laporan;

import com.hindustries.dto.request.domain.laporan.LaporanHarianRequest;
import com.hindustries.dto.response.domain.laporan.LaporanHarianResponse;
import com.hindustries.entity.domain.laporan.LaporanHarian;
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