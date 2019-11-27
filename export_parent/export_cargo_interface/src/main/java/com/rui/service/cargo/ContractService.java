package com.rui.service.cargo;

import com.github.pagehelper.PageInfo;
import com.rui.domain.cargo.Contract;
import com.rui.domain.cargo.ContractExample;

public interface ContractService {
    //分页查询
    PageInfo findAll(ContractExample example, int page, int size);

    //根据id查询购销合同信息
    Contract findContractById(String id);

    void save(Contract contract);

    void update(Contract contract);

    void delete(String id);
}
