package com.hindustries.mapper;

import com.hindustries.dto.request.KasusPenyakitRequest;
import com.hindustries.dto.response.KasusPenyakitResponse;
import com.hindustries.entity.KasusPenyakit;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import java.util.List;

@Mapper(componentModel = "spring")
public interface KasusPenyakitMapper {
    KasusPenyakitResponse toResponse(KasusPenyakit entity);
    List<KasusPenyakitResponse> toResponse(List<KasusPenyakit> lsEntity);
    void updateEntityFromRequest(KasusPenyakitRequest request, @MappingTarget KasusPenyakit entity);
    KasusPenyakit toEntity(KasusPenyakitRequest request);
}
