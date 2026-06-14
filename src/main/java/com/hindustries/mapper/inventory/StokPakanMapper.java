package com.hindustries.mapper.inventory;

import com.hindustries.dto.request.inventory.StokPakanRequest;
import com.hindustries.dto.response.inventory.StokPakanResponse;
import com.hindustries.entity.inventory.StokPakan;
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
