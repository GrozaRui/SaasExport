package com.rui.service.cargo;

import com.github.pagehelper.PageInfo;
import com.rui.domain.cargo.ContractExample;

public interface ContractService {
    //分页查询
    PageInfo findAll(ContractExample example, int page, int size);
}
