package com.hindustries.mapper.farm;

import com.hindustries.dto.request.farm.KasusPenyakitRequest;
import com.hindustries.dto.response.farm.KasusPenyakitResponse;
import com.hindustries.entity.farm.KasusPenyakit;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import java.util.List;

@Mapper(componentModel = "spring")
public interface KasusPenyakitMapper {
    @Mapping(source = "kelompokAyam.namaKelompok", target = "namaKelompok")
    KasusPenyakitResponse toResponse(KasusPenyakit entity);
    List<KasusPenyakitResponse> toResponse(List<KasusPenyakit> lsEntity);
    void updateEntityFromRequest(KasusPenyakitRequest request, @MappingTarget KasusPenyakit entity);
    KasusPenyakit toEntity(KasusPenyakitRequest request);
}
