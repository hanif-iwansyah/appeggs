package com.hindustries.mapper;

import com.hindustries.dto.request.KaryawanRequest;
import com.hindustries.dto.response.KaryawanResponse;
import com.hindustries.entity.Karyawan;
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
