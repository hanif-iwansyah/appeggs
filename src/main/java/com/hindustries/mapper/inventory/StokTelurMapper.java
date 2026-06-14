package com.hindustries.mapper.inventory;

import com.hindustries.dto.request.inventory.StokTelurRequest;
import com.hindustries.dto.response.inventory.StokTelurResponse;
import com.hindustries.entity.inventory.StokTelur;
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
