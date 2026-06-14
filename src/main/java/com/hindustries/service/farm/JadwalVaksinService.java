package com.hindustries.service.farm;

import com.hindustries.base.BaseService;
import com.hindustries.dto.request.farm.JadwalVaksinRequest;
import com.hindustries.dto.response.farm.JadwalVaksinResponse;
import com.hindustries.entity.farm.JadwalVaksin;
import com.hindustries.mapper.farm.JadwalVaksinMapper;
import com.hindustries.repository.farm.JadwalVaksinRepository;
import com.hindustries.util.Constant;
import com.hindustries.util.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class JadwalVaksinService implements BaseService<JadwalVaksinRequest, JadwalVaksinResponse, Long> {
    
    private final JadwalVaksinRepository repository;
    private final JadwalVaksinMapper mapper;

    public JadwalVaksinService(JadwalVaksinRepository repository, JadwalVaksinMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public JadwalVaksinResponse create(JadwalVaksinRequest request) {
        JadwalVaksin entity = repository.save(mapper.toEntity(request));
        return mapper.toResponse(entity);
    }

    @Override
    public JadwalVaksinResponse update(Long id, JadwalVaksinRequest request) {
        JadwalVaksin entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.JADWAL_VAKSIN, id));
        mapper.updateEntityFromRequest(request, entity);
        repository.save(entity);
        return mapper.toResponse(entity);
    }

    @Override
    public List<JadwalVaksinResponse> findAll() {
        List<JadwalVaksin> lsEntity = repository.findAll();
        return mapper.toResponse(lsEntity);
    }

    @Override
    public JadwalVaksinResponse findById(Long id) {
        JadwalVaksin entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.JADWAL_VAKSIN, id));
        return mapper.toResponse(entity);
    }

    @Override
    public void delete(Long id) {
        repository.delete(repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.JADWAL_VAKSIN, id)));
    }

}
