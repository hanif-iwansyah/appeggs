package com.hindustries.mapper.domain.operasional.flock;

import com.hindustries.dto.request.domain.operasional.flock.KelompokAyamRequest;
import com.hindustries.dto.response.domain.operasional.flock.KelompokAyamResponse;
import com.hindustries.entity.domain.operasional.flock.KelompokAyam;
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
