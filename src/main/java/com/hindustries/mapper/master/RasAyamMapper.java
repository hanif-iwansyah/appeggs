package com.hindustries.mapper.master;

import com.hindustries.dto.request.master.RasAyamRequest;
import com.hindustries.dto.response.master.RasAyamResponse;
import com.hindustries.entity.master.RasAyam;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import java.util.List;

@Mapper(componentModel = "spring")
public interface RasAyamMapper {
    RasAyamResponse toResponse(RasAyam entity);
    List<RasAyamResponse> toResponse(List<RasAyam> lsEntity);
    void  updateEntityFromRequest(RasAyamRequest request, @MappingTarget RasAyam entity);
    RasAyam toEntity(RasAyamRequest request);
}
