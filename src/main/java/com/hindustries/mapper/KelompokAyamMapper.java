package com.hindustries.mapper;

import com.hindustries.dto.request.KelompokAyamRequest;
import com.hindustries.dto.response.KelompokAyamResponse;
import com.hindustries.entity.KelompokAyam;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import java.util.List;

@Mapper(componentModel = "spring")
public interface KelompokAyamMapper {
    @Mapping(source = "ras.namaRas", target = "namaRas")
    @Mapping(source = "kandang.namaKandang", target = "namaKandang")
    KelompokAyamResponse toResponse(KelompokAyam entity);
    List<KelompokAyamResponse> toResponse(List<KelompokAyam> lsEntity);
    void updateEntityFromRequest(KelompokAyamRequest request, @MappingTarget KelompokAyam entity);
    KelompokAyam toEntity(KelompokAyamRequest request);
}
