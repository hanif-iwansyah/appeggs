package com.hindustries.mapper;

import com.hindustries.dto.request.JadwalVaksinRequest;
import com.hindustries.dto.response.JadwalVaksinResponse;
import com.hindustries.entity.JadwalVaksin;
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
