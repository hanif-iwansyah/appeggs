package com.hindustries.mapper;

import com.hindustries.dto.request.PenggunaRequest;
import com.hindustries.dto.response.PenggunaResponse;
import com.hindustries.entity.Pengguna;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import java.util.List;

@Mapper(componentModel = "spring")
public interface PenggunaMapper {
    PenggunaResponse toResponse(Pengguna entity);
    List<PenggunaResponse> toResponse(List<Pengguna> lsEntity);
    void updateEntityFromRequest(PenggunaRequest request, @MappingTarget Pengguna entity);
    Pengguna toEntity(PenggunaRequest request);
}
