package com.hindustries.mapper.system;

import com.hindustries.dto.request.system.KaryawanRequest;
import com.hindustries.dto.response.system.KaryawanResponse;
import com.hindustries.entity.system.Karyawan;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import java.util.List;

@Mapper(componentModel = "spring")
public interface KaryawanMapper {
    KaryawanResponse toResponse(Karyawan entity);
    List<KaryawanResponse> toResponse(List<Karyawan> lsEntity);
    void updateEntityFromRequest(KaryawanRequest request, @MappingTarget Karyawan entity);
    Karyawan toEntity(KaryawanRequest request);
}
