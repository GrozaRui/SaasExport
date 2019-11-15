package com.rui.dao.company;

import com.rui.domain.company.Company;

import java.util.List;

/**
 * @description: dao层接口
 * @author: caihongrui
 * @createtime: 2019-11-14 17:42
 **/
public interface CompanyDao {

    //查询所有数据
    public List<Company> findAll();

}
