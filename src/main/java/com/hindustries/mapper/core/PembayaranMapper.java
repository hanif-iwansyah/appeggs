package com.hindustries.mapper.core;

import com.hindustries.dto.request.core.PembayaranRequest;
import com.hindustries.dto.response.core.PembayaranResponse;
import com.hindustries.entity.core.Pembayaran;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import java.util.List;

@Mapper(componentModel = "spring")
public interface PembayaranMapper {
    PembayaranResponse toResponse(Pembayaran entity);
    List<PembayaranResponse> toResponse(List<Pembayaran> lsEntity);
    void updateEntityFromRequest(PembayaranRequest request, @MappingTarget Pembayaran entity);
    Pembayaran toEntity(PembayaranRequest request);
}