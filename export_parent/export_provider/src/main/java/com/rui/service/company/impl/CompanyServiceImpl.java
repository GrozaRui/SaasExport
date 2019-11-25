package com.rui.service.company.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rui.dao.company.CompanyDao;
import com.rui.domain.company.Company;
import com.rui.service.company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

/**
 * @description: 企业接口工程 - 企业接口实现类
 * @author: caihongrui
 * @createtime: 2019-11-22 10:19
 **/
@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyDao companyDao;

    @Override
    public List<Company> findAll() {
        return companyDao.findAll();
    }

    @Override
    public void save(Company company) {
        company.setId(UUID.randomUUID().toString());
        companyDao.save(company);
    }

    @Override
    public Company findById(String id) {
        return companyDao.findById(id);
    }

    @Override
    public void update(Company company) {
        companyDao.update(company);
    }

    @Override
    public void delete(String id) {
        companyDao.delete(id);
    }

    @Override
    public PageInfo findByPage(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<Company> companyList = companyDao.findAll();
        return new PageInfo(companyList);
    }
}
