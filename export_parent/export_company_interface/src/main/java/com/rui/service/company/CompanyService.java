package com.rui.service.company;

import com.github.pagehelper.PageInfo;
import com.rui.domain.company.Company;

import java.util.List;

/**
 * 公共接口 方便调用
 */
public interface CompanyService {
    //查询所有
    public List<Company> findAll();

    //添加企业
    void save(Company company);

    //根据id查询企业数据
    Company findById(String id);

    //修改企业数据
    void update(Company company);

    //删除企业数据
    void delete(String id);

    //分页查询
    PageInfo findByPage(Integer page, Integer pageSize);
}
