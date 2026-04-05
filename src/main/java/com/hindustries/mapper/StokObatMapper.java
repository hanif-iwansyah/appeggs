package com.hindustries.mapper;

import com.hindustries.dto.request.StokObatRequest;
import com.hindustries.dto.response.StokObatResponse;
import com.hindustries.entity.StokObat;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import java.util.List;

@Mapper(componentModel = "spring")
public interface StokObatMapper {
    StokObatResponse toResponse(StokObat entity);
    List<StokObatResponse> toResponse(List<StokObat> lsEntity);
    void updateEntityFromRequest(StokObatRequest request, @MappingTarget StokObat entity);
    StokObat toEntity(StokObatRequest request);
}
