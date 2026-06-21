package com.hindustries.mapper.domain.penjualan;

import com.hindustries.dto.request.domain.penjualan.PembayaranRequest;
import com.hindustries.dto.response.domain.penjualan.PembayaranResponse;
import com.hindustries.entity.domain.penjualan.Pembayaran;
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