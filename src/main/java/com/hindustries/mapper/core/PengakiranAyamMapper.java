package com.hindustries.mapper.core;

import com.hindustries.dto.request.core.PembelianPakanRequest;
import com.hindustries.dto.request.core.PengakiranAyamRequest;
import com.hindustries.dto.response.core.PembelianPakanResponse;
import com.hindustries.dto.response.core.PengakiranAyamResponse;
import com.hindustries.entity.core.PembelianPakan;
import com.hindustries.entity.core.PengakiranAyam;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import java.util.List;

@Mapper(componentModel = "spring")
public interface PengakiranAyamMapper {
    PengakiranAyamResponse toResponse(PengakiranAyam entity);
    List<PengakiranAyamResponse> toResponse(List<PengakiranAyam> lsEntity);
    void updateEntityFromRequest(PengakiranAyamRequest request, @MappingTarget PengakiranAyam entity);
    PengakiranAyam toEntity(PengakiranAyamRequest request);
}
