package com.hindustries.mapper.domain.master;

import com.hindustries.dto.request.domain.master.KandangRequest;
import com.hindustries.dto.response.domain.master.KandangResponse;
import com.hindustries.entity.domain.master.Kandang;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface KandangMapper {
    @Mapping(source = "peternakan.namaPeternakan", target = "namaPeternakan")
    KandangResponse toResponse(Kandang entity);
    List<KandangResponse> toResponse(List<Kandang> lsEntity);
    void  updateEntityFromRequest(KandangRequest request, @MappingTarget Kandang entity);
    Kandang toEntity(KandangRequest request);
}
