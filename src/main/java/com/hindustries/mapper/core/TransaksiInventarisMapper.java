package com.hindustries.mapper.core;

import com.hindustries.dto.request.core.TransaksiInventarisRequest;
import com.hindustries.dto.response.core.TransaksiInventarisResponse;
import com.hindustries.entity.core.TransaksiInventaris;
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
