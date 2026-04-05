package com.hindustries.mapper;

import com.hindustries.dto.request.KandangRequest;
import com.hindustries.dto.response.KandangResponse;
import com.hindustries.entity.Kandang;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

@Mapper(componentModel = "spring")
public interface KandangMapper {
    @Mapping(source = "peternakan.namaPeternakan", target = "namaPeternakan")
    KandangResponse toResponse(Kandang entity);
    List<KandangResponse> toResponse(List<Kandang> lsEntity);
    Kandang toEntity(KandangRequest request);
}
