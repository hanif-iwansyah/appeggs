package com.hindustries.mapper.domain.master;

import com.hindustries.dto.request.domain.master.PelangganRequest;
import com.hindustries.dto.response.domain.master.PelangganResponse;
import com.hindustries.entity.domain.master.Pelanggan;
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
