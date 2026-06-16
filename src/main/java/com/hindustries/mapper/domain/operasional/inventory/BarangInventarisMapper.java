package com.hindustries.mapper.domain.operasional.inventory;

import com.hindustries.dto.request.domain.operasional.inventory.BarangInventarisRequest;
import com.hindustries.dto.response.domain.operasional.inventory.BarangInventarisResponse;
import com.hindustries.entity.domain.operasional.inventory.BarangInventaris;
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
