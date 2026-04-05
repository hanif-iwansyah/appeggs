package com.hindustries.base;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BaseService<Req, Res, ID> {
    Res create(Req request);
    Res update(ID id, Req request);
    List<Res> findAll();
    Res findById(ID id);
    void delete(ID id);
    default List<Res> createBatch(List<Req> request) {
        throw new UnsupportedOperationException("Batch create not supported");
    }
}