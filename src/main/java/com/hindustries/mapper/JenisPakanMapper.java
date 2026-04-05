package com.hindustries.mapper;

import com.hindustries.dto.request.JenisPakanRequest;
import com.hindustries.dto.response.JenisPakanResponse;
import com.hindustries.entity.JenisPakan;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import java.util.List;

@Mapper(componentModel = "spring")
public interface JenisPakanMapper {
    JenisPakanResponse toResponse(JenisPakan entity);
    List<JenisPakanResponse> toResponse(List<JenisPakan> lsEntity);
    void  updateEntityFromRequest(JenisPakanRequest request, @MappingTarget JenisPakan entity);
    JenisPakan toEntity(JenisPakanRequest request);
}
