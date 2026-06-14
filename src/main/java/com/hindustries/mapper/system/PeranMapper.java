package com.hindustries.mapper.system;

import com.hindustries.dto.request.system.PeranRequest;
import com.hindustries.dto.response.system.PeranResponse;
import com.hindustries.entity.system.Peran;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import java.util.List;

@Mapper(componentModel = "spring")
public interface PeranMapper {
    PeranResponse toResponse(Peran entity);
    List<PeranResponse> toResponse(List<Peran> lsEntity);
    void updateEntityFromRequest(PeranRequest request, @MappingTarget Peran entity);
    Peran toEntity(PeranRequest request);
}
