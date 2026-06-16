package com.hindustries.mapper.domain.operasional.production;

import com.hindustries.dto.request.domain.operasional.production.ProduksiTelurRequest;
import com.hindustries.dto.response.domain.operasional.production.ProduksiTelurResponse;
import com.hindustries.entity.domain.operasional.production.ProduksiTelur;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ProduksiTelurMapper {
    @Mapping(source = "kelompokAyam.namaKelompok", target = "namaKelompokAyam")
    ProduksiTelurResponse toResponse(ProduksiTelur entity);
    List<ProduksiTelurResponse> toResponse(List<ProduksiTelur> lsEntity);
    void updateEntityFromRequest(ProduksiTelurRequest request, @MappingTarget ProduksiTelur entity);
    ProduksiTelur toEntity(ProduksiTelurRequest request);
}
