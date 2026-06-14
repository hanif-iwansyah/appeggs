package com.hindustries.mapper.master;

import com.hindustries.dto.request.master.PelangganRequest;
import com.hindustries.dto.response.master.PelangganResponse;
import com.hindustries.entity.master.Pelanggan;
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
