package com.hindustries.mapper;

import com.hindustries.dto.request.CatatanVaksinasiRequest;
import com.hindustries.dto.response.CatatanVaksinasiResponse;
import com.hindustries.entity.CatatanVaksinasi;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import java.util.List;

@Mapper(componentModel = "spring")
public interface CatatanVaksinasiMapper {
    CatatanVaksinasiResponse toResponse(CatatanVaksinasi entity);
    List<CatatanVaksinasiResponse> toResponse(List<CatatanVaksinasi> lsEntity);
    void updateEntityFromRequest(CatatanVaksinasiRequest request, @MappingTarget CatatanVaksinasi entity);
    CatatanVaksinasi toEntity(CatatanVaksinasiRequest request);
}
