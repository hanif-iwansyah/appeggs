package com.hindustries.mapper;

import com.hindustries.dto.request.StokTelurRequest;
import com.hindustries.dto.response.StokTelurResponse;
import com.hindustries.entity.StokTelur;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import java.util.List;

@Mapper(componentModel = "spring")
public interface StokTelurMapper {
    @Mapping(source = "gudang.namaGudang", target = "namaGudang")
    StokTelurResponse toResponse(StokTelur entity);
    List<StokTelurResponse> toResponse(List<StokTelur> lsEntity);
    void updateEntityFromRequest(StokTelurRequest request, @MappingTarget StokTelur entity);
    StokTelur toEntity(StokTelurRequest request);
}
