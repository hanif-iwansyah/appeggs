package com.hindustries.mapper.domain.operasional.flock;

import com.hindustries.dto.request.domain.operasional.flock.PengakiranAyamRequest;
import com.hindustries.dto.response.domain.operasional.flock.PengakiranAyamResponse;
import com.hindustries.entity.domain.operasional.flock.PengakiranAyam;
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
