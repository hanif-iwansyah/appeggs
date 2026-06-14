package com.hindustries.mapper.commerce;

import com.hindustries.dto.request.commerce.PembelianPakanDetailRequest;
import com.hindustries.dto.response.commerce.PembelianPakanDetailResponse;
import com.hindustries.entity.commerce.PembelianPakanDetail;
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
