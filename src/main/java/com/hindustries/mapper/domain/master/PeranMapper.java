package com.hindustries.mapper.domain.master;

import com.hindustries.dto.request.domain.master.PeranRequest;
import com.hindustries.dto.response.domain.master.PeranResponse;
import com.hindustries.entity.domain.master.Peran;
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
