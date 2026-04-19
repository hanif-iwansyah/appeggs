package com.hindustries.mapper;

import com.hindustries.dto.request.KonsumsiPakanRequest;
import com.hindustries.dto.response.KonsumsiPakanResponse;
import com.hindustries.entity.KonsumsiPakan;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import java.util.List;

@Mapper(componentModel = "spring")
public interface KonsumsiPakanMapper {
    KonsumsiPakanResponse toResponse(KonsumsiPakan entity);
    List<KonsumsiPakanResponse> toResponse(List<KonsumsiPakan> lsEntity);
    void updateEntityFromRequest(KonsumsiPakanRequest request, @MappingTarget KonsumsiPakan entity);
    KonsumsiPakan toEntity(KonsumsiPakanRequest request);
}
