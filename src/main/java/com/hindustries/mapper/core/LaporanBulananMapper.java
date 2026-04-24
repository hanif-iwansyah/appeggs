package com.hindustries.mapper.core;

import com.hindustries.dto.request.core.LaporanBulananRequest;
import com.hindustries.dto.response.core.LaporanBulananResponse;
import com.hindustries.entity.core.LaporanBulanan;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import java.util.List;

@Mapper(componentModel = "spring")
public interface LaporanBulananMapper {
    LaporanBulananResponse toResponse(LaporanBulanan entity);
    List<LaporanBulananResponse> toResponse(List<LaporanBulanan> lsEntity);
    void updateEntityFromRequest(LaporanBulananRequest request, @MappingTarget LaporanBulanan entity);
    LaporanBulanan toEntity(LaporanBulananRequest request);
}
