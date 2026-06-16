package com.hindustries.mapper.domain.master;

import com.hindustries.dto.request.domain.master.GudangRequest;
import com.hindustries.dto.response.domain.master.GudangResponse;
import com.hindustries.entity.domain.master.Gudang;
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
