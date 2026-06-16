package com.hindustries.mapper.domain.pembelian;

import com.hindustries.dto.request.domain.pembelian.PembelianPakanDetailRequest;
import com.hindustries.dto.response.domain.pembelian.PembelianPakanDetailResponse;
import com.hindustries.entity.domain.pembelian.PembelianPakanDetail;
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
