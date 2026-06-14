package com.hindustries.mapper.inventory;

import com.hindustries.dto.request.inventory.TransaksiInventarisRequest;
import com.hindustries.dto.response.inventory.TransaksiInventarisResponse;
import com.hindustries.entity.inventory.TransaksiInventaris;
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
