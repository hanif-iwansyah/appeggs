package com.hindustries.service.system;

import com.hindustries.base.BaseService;
import com.hindustries.dto.request.system.KaryawanRequest;
import com.hindustries.dto.response.system.KaryawanResponse;
import com.hindustries.entity.system.Karyawan;
import com.hindustries.mapper.system.KaryawanMapper;
import com.hindustries.repository.system.KaryawanRepository;
import com.hindustries.util.Constant;
import com.hindustries.util.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class KaryawanService implements BaseService<KaryawanRequest, KaryawanResponse, Long> {

    private final KaryawanRepository repository;
    private final KaryawanMapper mapper;

    public KaryawanService(KaryawanRepository repository, KaryawanMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public KaryawanResponse create(KaryawanRequest request) {
        Karyawan entity = repository.save(mapper.toEntity(request));
        return mapper.toResponse(entity);
    }

    @Override
    public KaryawanResponse update(Long id, KaryawanRequest request) {
        Karyawan entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.KARYAWAN, id));
        mapper.updateEntityFromRequest(request, entity);
        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public List<KaryawanResponse> findAll() {
        List<Karyawan> lsEntity = repository.findAll();
        return mapper.toResponse(lsEntity);
    }

    @Override
    public KaryawanResponse findById(Long id) {
        return mapper.toResponse(repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.KARYAWAN, id)));
    }

    @Override
    public void delete(Long id) {
        repository.delete(repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.KARYAWAN, id)));
    }
}
