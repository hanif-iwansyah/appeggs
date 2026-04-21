package com.hindustries.mapper;

import com.hindustries.dto.request.KematianAyamRequest;
import com.hindustries.dto.response.KematianAyamResponse;
import com.hindustries.entity.KematianAyam;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import java.util.List;

@Mapper(componentModel = "spring")
public interface KematianAyamMapper {
    @Mapping(source = "kelompokAyam.namaKelompok", target = "namaKelompokAyam")
    KematianAyamResponse toResponse(KematianAyam entity);
    List<KematianAyamResponse> toResponse(List<KematianAyam> lsEntity);
    void updateEntityFromRequest(KematianAyamRequest request, @MappingTarget KematianAyam entity);
    KematianAyam toEntity(KematianAyamRequest request);
}
