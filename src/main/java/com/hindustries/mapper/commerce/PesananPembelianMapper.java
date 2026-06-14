package com.hindustries.mapper.commerce;

import com.hindustries.dto.request.commerce.PesananPembelianRequest;
import com.hindustries.dto.response.commerce.PesananPembelianResponse;
import com.hindustries.entity.commerce.PesananPembelian;
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
