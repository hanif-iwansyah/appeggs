package com.hindustries.mapper.domain.operasional.health;

import com.hindustries.dto.request.domain.operasional.health.KasusPenyakitRequest;
import com.hindustries.dto.response.domain.operasional.health.KasusPenyakitResponse;
import com.hindustries.entity.domain.operasional.health.KasusPenyakit;
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
