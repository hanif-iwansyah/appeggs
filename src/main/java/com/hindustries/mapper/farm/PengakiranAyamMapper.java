package com.hindustries.mapper.farm;

import com.hindustries.dto.request.commerce.PengakiranAyamRequest;
import com.hindustries.dto.response.farm.PengakiranAyamResponse;
import com.hindustries.entity.farm.PengakiranAyam;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import java.util.List;

@Mapper(componentModel = "spring")
public interface PengakiranAyamMapper {
    PengakiranAyamResponse toResponse(PengakiranAyam entity);
    List<PengakiranAyamResponse> toResponse(List<PengakiranAyam> lsEntity);
    void updateEntityFromRequest(PengakiranAyamRequest request, @MappingTarget PengakiranAyam entity);
    PengakiranAyam toEntity(PengakiranAyamRequest request);
}
