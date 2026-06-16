package com.hindustries.mapper.domain.master;

import com.hindustries.dto.request.domain.master.PeternakanRequest;
import com.hindustries.dto.response.domain.master.PeternakanResponse;
import com.hindustries.entity.domain.master.Peternakan;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import java.util.List;

@Mapper(componentModel = "spring")
public interface PeternakanMapper {
    PeternakanResponse toResponse(Peternakan entity);
    List<PeternakanResponse> toResponse(List<Peternakan> lsEntity);
    void  updateEntityFromRequest(PeternakanRequest request, @MappingTarget Peternakan entity);
    Peternakan toEntity(PeternakanRequest request);
}