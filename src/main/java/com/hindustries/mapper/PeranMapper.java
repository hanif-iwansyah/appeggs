package com.hindustries.mapper;

import com.hindustries.dto.request.PeranRequest;
import com.hindustries.dto.response.PeranResponse;
import com.hindustries.entity.Peran;
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
