package com.hindustries.mapper.farm;

import com.hindustries.dto.request.farm.GradingTelurRequest;
import com.hindustries.dto.response.farm.GradingTelurResponse;
import com.hindustries.entity.farm.GradingTelur;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import java.util.List;

@Mapper(componentModel = "spring")
public interface GradingTelurMapper {
    @Mapping(source = "produksiTelur.kelompokAyam.namaKelompok", target = "namaKelompokAyam")
    GradingTelurResponse toResponse(GradingTelur entity);
    List<GradingTelurResponse> toResponse(List<GradingTelur> lsEntity);
    void updateEntityFromRequest(GradingTelurRequest request, @MappingTarget GradingTelur entity);
    GradingTelur toEntity(GradingTelurRequest request);
}
