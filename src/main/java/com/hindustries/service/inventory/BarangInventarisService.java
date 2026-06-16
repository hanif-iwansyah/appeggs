package com.hindustries.service.inventory;

import com.hindustries.base.BaseService;
import com.hindustries.dto.request.inventory.BarangInventarisRequest;
import com.hindustries.dto.response.inventory.BarangInventarisResponse;
import com.hindustries.entity.inventory.BarangInventaris;
import com.hindustries.mapper.inventory.BarangInventarisMapper;
import com.hindustries.repository.BarangInventarisRepository;
import com.hindustries.util.Constant;
import com.hindustries.util.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BarangInventarisService implements BaseService<BarangInventarisRequest, BarangInventarisResponse, Long> {

    private final BarangInventarisRepository repository;
    private final BarangInventarisMapper mapper;

    public BarangInventarisService(BarangInventarisRepository repository, BarangInventarisMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public BarangInventarisResponse create(BarangInventarisRequest request) {
        return mapper.toResponse(repository.save(mapper.toEntity(request)));
    }

    @Override
    public BarangInventarisResponse update(Long id, BarangInventarisRequest request) {
        BarangInventaris entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.BARANG_INVENTARIS, id));
        mapper.updateEntityFromRequest(request, entity);
        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public List<BarangInventarisResponse> findAll() {
        List<BarangInventaris> lsEntity = repository.findAll();
        return mapper.toResponse(lsEntity);
    }

    @Override
    public BarangInventarisResponse findById(Long id) {
        BarangInventaris entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.BARANG_INVENTARIS, id));
        return mapper.toResponse(entity);
    }

    @Override
    public void delete(Long id) {
        repository.delete(repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.BARANG_INVENTARIS, id)));
    }
}
