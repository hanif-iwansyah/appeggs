package com.hindustries.mapper.commerce;

import com.hindustries.dto.request.commerce.PembelianPakanRequest;
import com.hindustries.dto.response.commerce.PembelianPakanResponse;
import com.hindustries.entity.commerce.PembelianPakan;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import java.util.List;

@Mapper(componentModel = "spring")
public interface PembelianPakanMapper {
    PembelianPakanResponse toResponse(PembelianPakan entity);
    List<PembelianPakanResponse> toResponse(List<PembelianPakan> lsEntity);
    void updateEntityFromRequest(PembelianPakanRequest request, @MappingTarget PembelianPakan entity);
    PembelianPakan toEntity(PembelianPakanRequest request);
}