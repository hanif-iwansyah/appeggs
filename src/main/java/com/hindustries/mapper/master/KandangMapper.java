package com.hindustries.mapper.master;

import com.hindustries.dto.request.master.KandangRequest;
import com.hindustries.dto.response.master.KandangResponse;
import com.hindustries.entity.master.Kandang;
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
