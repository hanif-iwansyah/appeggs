package com.hindustries.mapper.system;

import com.hindustries.dto.request.system.LaporanBulananRequest;
import com.hindustries.dto.response.system.LaporanBulananResponse;
import com.hindustries.entity.system.LaporanBulanan;
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
