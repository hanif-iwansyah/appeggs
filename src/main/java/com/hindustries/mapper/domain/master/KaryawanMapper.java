package com.hindustries.mapper.domain.master;

import com.hindustries.dto.request.domain.master.KaryawanRequest;
import com.hindustries.dto.response.domain.master.KaryawanResponse;
import com.hindustries.entity.domain.master.Karyawan;
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
