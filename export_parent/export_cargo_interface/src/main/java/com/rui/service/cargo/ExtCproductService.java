package com.rui.service.cargo;

import com.github.pagehelper.PageInfo;
import com.rui.domain.cargo.ExtCproduct;
import com.rui.domain.cargo.ExtCproductExample;

public interface ExtCproductService {

    PageInfo findAll(ExtCproductExample extCproductExample, int page, int size);

    ExtCproduct findExtCproductById(String id);

    void save(ExtCproduct extCproduct);

    void update(ExtCproduct extCproduct);

    void delete(String id);
}
