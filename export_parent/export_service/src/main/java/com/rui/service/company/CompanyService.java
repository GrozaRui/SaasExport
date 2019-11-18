package com.rui.service.company;

import com.rui.domain.company.Company;
import com.rui.entity.PageResult;

import java.util.List;

/**
 * @description: 公司业务service层接口
 * @author: caihongrui
 * @createtime: 2019-11-14 17:52
 **/
public interface CompanyService {

    //查询所有
    List<Company> findAll();

    //根据id查询
    Company findById(String id);

    //保存数据
    void save(Company company);

    //修改数据
    void update(Company company);

    //删除数据
    void delete(String id);

    //分页查询
    PageResult findByPage(int page, int size);
}
