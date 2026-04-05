package com.hindustries.base;

import com.hindustries.util.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

public abstract class BaseController <Req, Res, ID> {

    protected abstract BaseService<Req, Res, ID> getService();

    @PostMapping
    public ResponseEntity<ApiResponse<Res>> create(@Valid @RequestBody Req request) {
        Res data = getService().create(request);
        return ResponseEntity.ok(ApiResponse.success(data));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Res>> update(
            @PathVariable ID id,
            @Valid @RequestBody Req request
    ) {
        Res data = getService().update(id, request);
        return ResponseEntity.ok(ApiResponse.success(data));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Res>>> findAll() {
        List<Res> data = getService().findAll();
        return ResponseEntity.ok(ApiResponse.success(data));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Res>> findById(@PathVariable ID id) {
        Res data = getService().findById(id);
        return ResponseEntity.ok(ApiResponse.success(data));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Object>> delete(@PathVariable ID id) {
        getService().delete(id);
        return ResponseEntity.ok(ApiResponse.success(null));
    }

}
