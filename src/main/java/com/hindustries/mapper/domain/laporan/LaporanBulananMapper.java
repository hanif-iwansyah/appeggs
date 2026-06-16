package com.hindustries.mapper.domain.laporan;

import com.hindustries.dto.request.domain.laporan.LaporanBulananRequest;
import com.hindustries.dto.response.domain.laporan.LaporanBulananResponse;
import com.hindustries.entity.domain.laporan.LaporanBulanan;
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
