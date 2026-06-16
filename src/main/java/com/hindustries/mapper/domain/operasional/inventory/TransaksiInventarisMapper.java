package com.hindustries.mapper.domain.operasional.inventory;

import com.hindustries.dto.request.domain.operasional.inventory.TransaksiInventarisRequest;
import com.hindustries.dto.response.domain.operasional.inventory.TransaksiInventarisResponse;
import com.hindustries.entity.domain.operasional.inventory.TransaksiInventaris;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import java.util.List;


@Mapper(componentModel = "spring")
public interface TransaksiInventarisMapper {
    TransaksiInventarisResponse toResponse(TransaksiInventaris entity);
    List<TransaksiInventarisResponse> toResponse(List<TransaksiInventaris> lsEntity);
    void updateEntityFromRequest(TransaksiInventarisRequest request, @MappingTarget TransaksiInventaris entity);
    TransaksiInventaris toEntity(TransaksiInventarisRequest request);
}
