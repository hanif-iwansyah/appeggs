package com.hindustries.mapper.domain.master;

import com.hindustries.dto.request.domain.master.JenisPakanRequest;
import com.hindustries.dto.response.domain.master.JenisPakanResponse;
import com.hindustries.entity.domain.master.JenisPakan;
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
