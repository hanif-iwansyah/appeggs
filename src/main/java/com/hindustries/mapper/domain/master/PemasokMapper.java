package com.hindustries.mapper.domain.master;

import com.hindustries.dto.request.domain.master.PemasokRequest;
import com.hindustries.dto.response.domain.master.PemasokResponse;
import com.hindustries.entity.domain.master.Pemasok;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import java.util.List;

@Mapper(componentModel = "spring")
public interface PemasokMapper {
    PemasokResponse toResponse(Pemasok entity);
    List<PemasokResponse> toResponse(List<Pemasok> lsEntity);
    void  updateEntityFromRequest(PemasokRequest request, @MappingTarget Pemasok entity);
    Pemasok toEntity(PemasokRequest request);
}
