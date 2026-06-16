package com.hindustries.service.domain.operasional.inventory;

import com.hindustries.base.BaseService;
import com.hindustries.dto.request.domain.operasional.inventory.TransaksiInventarisRequest;
import com.hindustries.dto.response.domain.operasional.inventory.TransaksiInventarisResponse;
import com.hindustries.entity.domain.operasional.inventory.BarangInventaris;
import com.hindustries.entity.domain.operasional.inventory.TransaksiInventaris;
import com.hindustries.mapper.domain.operasional.inventory.TransaksiInventarisMapper;
import com.hindustries.repository.domain.operasional.inventory.BarangInventarisRepository;
import com.hindustries.repository.domain.operasional.inventory.TransaksiInventarisRepository;
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
