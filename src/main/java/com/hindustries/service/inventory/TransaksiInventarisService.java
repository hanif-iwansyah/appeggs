package com.hindustries.service.inventory;

import com.hindustries.base.BaseService;
import com.hindustries.dto.request.inventory.TransaksiInventarisRequest;
import com.hindustries.dto.response.inventory.TransaksiInventarisResponse;
import com.hindustries.entity.inventory.BarangInventaris;
import com.hindustries.entity.inventory.TransaksiInventaris;
import com.hindustries.mapper.inventory.TransaksiInventarisMapper;
import com.hindustries.repository.inventory.BarangInventarisRepository;
import com.hindustries.repository.inventory.TransaksiInventarisRepository;
import com.hindustries.util.Constant;
import com.hindustries.util.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TransaksiInventarisService implements BaseService<TransaksiInventarisRequest, TransaksiInventarisResponse, Long> {

    private final BarangInventarisRepository barangInventarisRepository;
    private final TransaksiInventarisRepository repository;
    private final TransaksiInventarisMapper mapper;

    public TransaksiInventarisService(BarangInventarisRepository barangInventarisRepository, TransaksiInventarisRepository repository, TransaksiInventarisMapper mapper) {
        this.barangInventarisRepository = barangInventarisRepository;
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public TransaksiInventarisResponse create(TransaksiInventarisRequest request) {
        BarangInventaris barangInventaris = barangInventarisRepository.findById(request.getBarangInventarisId())
                .orElseThrow(() -> new ResourceNotFoundException(Constant.BARANG_INVENTARIS, request.getBarangInventarisId()));
        TransaksiInventaris entity = mapper.toEntity(request);
        entity.setBarangInventaris(barangInventaris);
        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public TransaksiInventarisResponse update(Long id, TransaksiInventarisRequest request) {
        TransaksiInventaris entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.TRANSAKSI_INVENTARIS, id));
        mapper.updateEntityFromRequest(request, entity);
        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public List<TransaksiInventarisResponse> findAll() {
        List<TransaksiInventaris> lsEntity = repository.findAll();
        return mapper.toResponse(lsEntity);
    }

    @Override
    public TransaksiInventarisResponse findById(Long id) {
        TransaksiInventaris entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.TRANSAKSI_INVENTARIS, id));
        return mapper.toResponse(entity);
    }

    @Override
    public void delete(Long id) {
        repository.delete(repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.TRANSAKSI_INVENTARIS, id)));
    }
}
