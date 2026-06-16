package com.hindustries.service.domain.operasional.health;

import com.hindustries.base.BaseService;
import com.hindustries.dto.request.domain.operasional.health.JadwalVaksinRequest;
import com.hindustries.dto.response.domain.operasional.health.JadwalVaksinResponse;
import com.hindustries.entity.domain.operasional.health.JadwalVaksin;
import com.hindustries.mapper.domain.operasional.health.JadwalVaksinMapper;
import com.hindustries.repository.domain.operasional.health.JadwalVaksinRepository;
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
