package com.hindustries.mapper.domain.operasional.inventory;

import com.hindustries.dto.request.domain.operasional.inventory.StokPakanRequest;
import com.hindustries.dto.response.domain.operasional.inventory.StokPakanResponse;
import com.hindustries.entity.domain.operasional.inventory.StokPakan;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

@Mapper(componentModel = "spring")
public interface StokPakanMapper {
    @Mapping(source = "jenisPakan.namaPakan", target = "namaPakan")
    @Mapping(source = "gudang.namaGudang", target = "namaGudang")
    StokPakanResponse toResponse(StokPakan entity);
    List<StokPakanResponse> toResponse(List<StokPakan> lsEntity);
    StokPakan toEntity(StokPakanRequest request);
}
