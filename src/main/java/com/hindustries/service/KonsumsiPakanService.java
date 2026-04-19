package com.hindustries.service;

import com.hindustries.base.BaseService;
import com.hindustries.dto.request.KonsumsiPakanRequest;
import com.hindustries.dto.response.KonsumsiPakanResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KonsumsiPakanService implements BaseService<KonsumsiPakanRequest, KonsumsiPakanResponse, Long> {
    @Override
    public KonsumsiPakanResponse create(KonsumsiPakanRequest request) {
        return null;
    }

    @Override
    public KonsumsiPakanResponse update(Long aLong, KonsumsiPakanRequest request) {
        return null;
    }

    @Override
    public List<KonsumsiPakanResponse> findAll() {
        return List.of();
    }

    @Override
    public KonsumsiPakanResponse findById(Long aLong) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }
}
