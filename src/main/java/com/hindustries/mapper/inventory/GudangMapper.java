package com.hindustries.mapper.inventory;

import com.hindustries.dto.request.inventory.GudangRequest;
import com.hindustries.dto.response.inventory.GudangResponse;
import com.hindustries.entity.inventory.Gudang;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import java.util.List;

@Mapper(componentModel = "spring")
public interface GudangMapper {
    GudangResponse toResponse(Gudang Entity);
    List<GudangResponse> toResponse(List<Gudang> lsEntity);
    void updateEntityFromRequest(GudangRequest request, @MappingTarget Gudang entity);
    Gudang toEntity(GudangRequest request);
}
