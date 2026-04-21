package com.hindustries.mapper;

import com.hindustries.dto.request.GradingTelurRequest;
import com.hindustries.dto.response.GradingTelurResponse;
import com.hindustries.entity.GradingTelur;
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
