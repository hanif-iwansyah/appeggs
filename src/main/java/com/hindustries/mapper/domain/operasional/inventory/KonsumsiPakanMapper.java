package com.hindustries.mapper.domain.operasional.inventory;

import com.hindustries.dto.request.domain.operasional.inventory.KonsumsiPakanRequest;
import com.hindustries.dto.response.domain.operasional.inventory.KonsumsiPakanResponse;
import com.hindustries.entity.domain.operasional.inventory.KonsumsiPakan;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import java.util.List;

@Mapper(componentModel = "spring")
public interface KonsumsiPakanMapper {
    @Mapping(source = "kelompokAyam.namaKelompok", target = "namaKelompokAyam")
    @Mapping(source = "jenisPakan.namaPakan", target = "namaJenisPakan")
    KonsumsiPakanResponse toResponse(KonsumsiPakan entity);
    List<KonsumsiPakanResponse> toResponse(List<KonsumsiPakan> lsEntity);
    void updateEntityFromRequest(KonsumsiPakanRequest request, @MappingTarget KonsumsiPakan entity);
    KonsumsiPakan toEntity(KonsumsiPakanRequest request);
}
