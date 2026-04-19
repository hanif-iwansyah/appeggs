package com.hindustries.service;

import com.hindustries.base.BaseService;
import com.hindustries.dto.request.ProduksiTelurRequest;
import com.hindustries.dto.response.ProduksiTelurResponse;
import com.hindustries.repository.ProduksiTelurRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProduksiTelurService implements BaseService<ProduksiTelurRequest, ProduksiTelurResponse, Long> {

    private final ProduksiTelurRepository repository;

    public ProduksiTelurService(ProduksiTelurRepository repository) {
        this.repository = repository;
    }

    @Override
    public ProduksiTelurResponse create(ProduksiTelurRequest request) {
        return null;
    }

    @Override
    public ProduksiTelurResponse update(Long aLong, ProduksiTelurRequest request) {
        return null;
    }

    @Override
    public List<ProduksiTelurResponse> findAll() {
        return List.of();
    }

    @Override
    public ProduksiTelurResponse findById(Long aLong) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }
}
