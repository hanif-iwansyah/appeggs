package com.hindustries.mapper.core;

import com.hindustries.dto.request.core.PembelianPakanDetailRequest;
import com.hindustries.dto.response.core.PembelianPakanDetailResponse;
import com.hindustries.entity.core.PembelianPakanDetail;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import java.util.List;

@Mapper(componentModel = "spring")
public interface PembelianPakanDetailMapper {
    PembelianPakanDetailResponse toResponse(PembelianPakanDetail entity);
    List<PembelianPakanDetailResponse> toResponse(List<PembelianPakanDetail> lsEntity);
    void updateEntityFromRequest(PembelianPakanDetailRequest request, @MappingTarget PembelianPakanDetail entity);
    PembelianPakanDetail toEntity(PembelianPakanDetailRequest request);
}
