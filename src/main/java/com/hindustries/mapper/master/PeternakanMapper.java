package com.hindustries.mapper.master;

import com.hindustries.dto.request.master.PeternakanRequest;
import com.hindustries.dto.response.master.PeternakanResponse;
import com.hindustries.entity.master.Peternakan;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface PeternakanMapper {
    PeternakanResponse toResponse(Peternakan entity);
    List<PeternakanResponse> toResponse(List<Peternakan> lsEntity);
    Peternakan toEntity(PeternakanRequest request);
}