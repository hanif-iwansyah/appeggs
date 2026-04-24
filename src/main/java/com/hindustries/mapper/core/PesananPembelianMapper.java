package com.hindustries.mapper.core;

import com.hindustries.dto.request.core.PesananPembelianRequest;
import com.hindustries.dto.response.core.PesananPembelianResponse;
import com.hindustries.entity.core.PesananPembelian;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import java.util.List;

@Mapper(componentModel = "spring")
public interface PesananPembelianMapper {
    PesananPembelianResponse toResponse(PesananPembelian entity);
    List<PesananPembelianResponse> toResponse(List<PesananPembelian> lsEntity);
    void updateEntityFromRequest(PesananPembelianRequest request, @MappingTarget PesananPembelian entity);
    PesananPembelian toEntity(PesananPembelianRequest request);
}
