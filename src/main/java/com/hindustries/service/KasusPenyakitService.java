package com.hindustries.service;

import com.hindustries.base.BaseService;
import com.hindustries.dto.request.KasusPenyakitRequest;
import com.hindustries.dto.response.KasusPenyakitResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KasusPenyakitService implements BaseService<KasusPenyakitRequest, KasusPenyakitResponse, Long> {
    @Override
    public KasusPenyakitResponse create(KasusPenyakitRequest request) {
        return null;
    }

    @Override
    public KasusPenyakitResponse update(Long aLong, KasusPenyakitRequest request) {
        return null;
    }

    @Override
    public List<KasusPenyakitResponse> findAll() {
        return List.of();
    }

    @Override
    public KasusPenyakitResponse findById(Long aLong) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }
}
