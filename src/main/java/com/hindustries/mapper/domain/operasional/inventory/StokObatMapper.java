package com.hindustries.mapper.domain.operasional.inventory;

import com.hindustries.dto.request.domain.operasional.inventory.StokObatRequest;
import com.hindustries.dto.response.domain.operasional.inventory.StokObatResponse;
import com.hindustries.entity.domain.operasional.inventory.StokObat;
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
