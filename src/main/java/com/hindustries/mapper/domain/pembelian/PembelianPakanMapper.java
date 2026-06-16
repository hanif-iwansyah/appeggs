package com.hindustries.mapper.domain.pembelian;

import com.hindustries.dto.request.domain.pembelian.PembelianPakanRequest;
import com.hindustries.dto.response.domain.pembelian.PembelianPakanResponse;
import com.hindustries.entity.domain.pembelian.PembelianPakan;
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