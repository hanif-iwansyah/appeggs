package com.hindustries.service.domain.master;

import com.hindustries.base.BaseServiceImpl;
import com.hindustries.dto.request.domain.master.KaryawanRequest;
import com.hindustries.dto.response.domain.master.KaryawanResponse;
import com.hindustries.entity.domain.master.Karyawan;
import com.hindustries.mapper.domain.master.KaryawanMapper;
import com.hindustries.repository.domain.master.KaryawanRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class KaryawanService extends BaseServiceImpl<Karyawan, KaryawanRequest, KaryawanResponse, Long> {

    private final KaryawanRepository repository;
    private final KaryawanMapper mapper;

    public KaryawanService(KaryawanRepository repository, KaryawanMapper mapper) {
        super(Karyawan.class);
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    protected JpaRepository<Karyawan, Long> getRepository() {
        return repository;
    }

    @Override
    protected KaryawanResponse mapToResponse(Karyawan karyawan) {
        return mapper.toResponse(karyawan);
    }

    @Override
    protected Karyawan mapToEntity(KaryawanRequest request) {
        return mapper.toEntity(request);
    }

    @Override
    protected void updateEntityFromReq(KaryawanRequest request, Karyawan entity) {
        mapper.updateEntityFromRequest(request, entity);
    }

}
