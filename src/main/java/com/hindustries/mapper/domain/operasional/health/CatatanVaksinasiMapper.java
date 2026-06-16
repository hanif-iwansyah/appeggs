package com.hindustries.mapper.domain.operasional.health;

import com.hindustries.dto.request.domain.operasional.health.CatatanVaksinasiRequest;
import com.hindustries.dto.response.domain.operasional.health.CatatanVaksinasiResponse;
import com.hindustries.entity.domain.operasional.health.CatatanVaksinasi;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import java.util.List;

@Mapper(componentModel = "spring")
public interface CatatanVaksinasiMapper {
    @Mapping(source = "kelompokAyam.namaKelompok", target = "namaKelompokAyam")
    CatatanVaksinasiResponse toResponse(CatatanVaksinasi entity);
    List<CatatanVaksinasiResponse> toResponse(List<CatatanVaksinasi> lsEntity);
    void updateEntityFromRequest(CatatanVaksinasiRequest request, @MappingTarget CatatanVaksinasi entity);
    CatatanVaksinasi toEntity(CatatanVaksinasiRequest request);
}
