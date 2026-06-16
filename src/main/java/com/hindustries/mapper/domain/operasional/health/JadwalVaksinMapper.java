package com.hindustries.mapper.domain.operasional.health;

import com.hindustries.dto.request.domain.operasional.health.JadwalVaksinRequest;
import com.hindustries.dto.response.domain.operasional.health.JadwalVaksinResponse;
import com.hindustries.entity.domain.operasional.health.JadwalVaksin;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import java.util.List;

@Mapper(componentModel = "spring")
public interface JadwalVaksinMapper {
    JadwalVaksinResponse toResponse(JadwalVaksin entity);
    List<JadwalVaksinResponse> toResponse(List<JadwalVaksin> lsEntity);
    void  updateEntityFromRequest(JadwalVaksinRequest request, @MappingTarget JadwalVaksin entity);
    JadwalVaksin toEntity(JadwalVaksinRequest request);
}
