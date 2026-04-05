package com.hindustries.mapper;

import com.hindustries.dto.request.PelangganRequest;
import com.hindustries.dto.response.PelangganResponse;
import com.hindustries.entity.Pelanggan;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import java.util.List;

@Mapper(componentModel = "spring")
public interface PelangganMapper {
    PelangganResponse toResponse(Pelanggan entity);
    List<PelangganResponse> toResponse(List<Pelanggan> lsEntity);
    void upadateEntityFromRequest(PelangganRequest request, @MappingTarget Pelanggan entity);
    Pelanggan toEntity(PelangganRequest request);
}
