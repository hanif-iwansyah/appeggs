package com.hindustries.service;

import com.hindustries.base.BaseService;
import com.hindustries.dto.request.KematianAyamRequest;
import com.hindustries.dto.response.KematianAyamResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KematianAyamService implements BaseService<KematianAyamRequest, KematianAyamResponse, Long> {
    @Override
    public KematianAyamResponse create(KematianAyamRequest request) {
        return null;
    }

    @Override
    public KematianAyamResponse update(Long aLong, KematianAyamRequest request) {
        return null;
    }

    @Override
    public List<KematianAyamResponse> findAll() {
        return List.of();
    }

    @Override
    public KematianAyamResponse findById(Long aLong) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }
}
