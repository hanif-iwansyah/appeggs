package com.hindustries.mapper.farm;

import com.hindustries.dto.request.farm.CatatanVaksinasiRequest;
import com.hindustries.dto.response.farm.CatatanVaksinasiResponse;
import com.hindustries.entity.farm.CatatanVaksinasi;
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
