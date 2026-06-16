package com.hindustries.mapper.domain.pembelian;

import com.hindustries.dto.request.domain.pembelian.PembayaranRequest;
import com.hindustries.dto.response.domain.pembelian.PembayaranResponse;
import com.hindustries.entity.domain.pembelian.Pembayaran;
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