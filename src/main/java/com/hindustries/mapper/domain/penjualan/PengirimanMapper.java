package com.hindustries.mapper.domain.penjualan;

import com.hindustries.dto.request.domain.penjualan.PengirimanRequest;
import com.hindustries.dto.response.domain.penjualan.PengirimanResponse;
import com.hindustries.entity.domain.penjualan.Pengiriman;
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
