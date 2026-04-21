package com.hindustries.mapper;

import com.hindustries.dto.request.ProduksiTelurRequest;
import com.hindustries.dto.response.ProduksiTelurResponse;
import com.hindustries.entity.ProduksiTelur;
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
