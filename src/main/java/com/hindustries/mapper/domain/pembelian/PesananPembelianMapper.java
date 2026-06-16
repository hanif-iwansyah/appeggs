package com.hindustries.mapper.domain.pembelian;

import com.hindustries.dto.request.domain.pembelian.PesananPembelianRequest;
import com.hindustries.dto.response.domain.pembelian.PesananPembelianResponse;
import com.hindustries.entity.domain.pembelian.PesananPembelian;
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
