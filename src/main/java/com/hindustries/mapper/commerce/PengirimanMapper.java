package com.hindustries.mapper.commerce;

import com.hindustries.dto.request.commerce.PengirimanRequest;
import com.hindustries.dto.response.commerce.PengirimanResponse;
import com.hindustries.entity.commerce.Pengiriman;
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
