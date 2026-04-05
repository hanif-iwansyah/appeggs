package com.hindustries.base;

import java.util.List;

public interface BaseBatchService <Req, Res>{
    List<Res> createBatch(List<Req> request);
}