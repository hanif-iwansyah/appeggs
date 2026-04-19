package com.hindustries.mapper;

import com.hindustries.dto.request.KelompokAyamRequest;
import com.hindustries.dto.response.KelompokAyamResponse;
import com.hindustries.entity.KelompokAyam;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import java.util.List;

@Mapper(componentModel = "spring")
public interface KelompokAyamMapper {
    KelompokAyamResponse toResponse(KelompokAyam entity);
    List<KelompokAyamResponse> toResponse(List<KelompokAyam> lsEntity);
    void updateEntityFromRequest(KelompokAyamRequest request, @MappingTarget KelompokAyam entity);
    KelompokAyam toEntity(KelompokAyamRequest request);
}
