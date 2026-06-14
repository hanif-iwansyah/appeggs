package com.hindustries.mapper.commerce;

import com.hindustries.dto.request.commerce.PembayaranRequest;
import com.hindustries.dto.response.commerce.PembayaranResponse;
import com.hindustries.entity.commerce.Pembayaran;
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