package com.hindustries.mapper.domain.master;

import com.hindustries.dto.request.domain.master.PenggunaRequest;
import com.hindustries.dto.response.domain.master.PenggunaResponse;
import com.hindustries.entity.domain.master.Pengguna;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import java.util.List;

@Mapper(componentModel = "spring")
public interface PenggunaMapper {
    @Mapping(source = "peran.namaPeran", target = "namaPeran")
    PenggunaResponse toResponse(Pengguna entity);
    List<PenggunaResponse> toResponse(List<Pengguna> lsEntity);
    void updateEntityFromRequest(PenggunaRequest request, @MappingTarget Pengguna entity);
    Pengguna toEntity(PenggunaRequest request);
}
