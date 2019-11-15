package com.rui.service.company;

import com.rui.domain.company.Company;

import java.util.List;

/**
 * @description: 公司业务service层接口
 * @author: caihongrui
 * @createtime: 2019-11-14 17:52
 **/
public interface CompanyService {

    //查询所有
    List<Company> findAll();

    //插入
    void insert(Company company);
}
