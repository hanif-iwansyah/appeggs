package com.hindustries.mapper;

import com.hindustries.dto.request.BarangInventarisRequest;
import com.hindustries.dto.response.BarangInventarisResponse;
import com.hindustries.entity.BarangInventaris;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import java.util.List;

@Mapper(componentModel = "spring")
public interface BarangInventarisMapper {
    BarangInventarisResponse toResponse(BarangInventaris entity);
    List<BarangInventarisResponse> toResponse(List<BarangInventaris> lsEntity);
    void updateEntityFromRequest(BarangInventarisRequest request, @MappingTarget BarangInventaris entity);
    BarangInventaris toEntity(BarangInventarisRequest request);
}
