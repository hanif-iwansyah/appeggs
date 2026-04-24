package com.hindustries.mapper.core;

import com.hindustries.dto.request.core.PengirimanRequest;
import com.hindustries.dto.response.core.PengirimanResponse;
import com.hindustries.entity.core.Pengiriman;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import java.util.List;

@Mapper(componentModel = "spring")
public interface PengirimanMapper {
    PengirimanResponse toResponse(Pengiriman entity);
    List<PengirimanResponse> toResponse(List<Pengiriman> lsEntity);
    void updateEntityFromRequest(PengirimanRequest request, @MappingTarget Pengiriman entity);
    Pengiriman toEntity(PengirimanRequest request);
}
