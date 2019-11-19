package com.rui.service.company.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rui.dao.company.CompanyDao;
import com.rui.domain.company.Company;
import com.rui.entity.PageResult;
import com.rui.service.company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * @description:
 * @author: caihongrui
 * @createtime: 2019-11-14 17:55
 **/
//@Transactional
@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyDao companyDao;

    @Override
    public List<Company> findAll() {
        System.out.println("进入service方法");
        return companyDao.findAll();
    }

    @Override
    public Company findById(String id) {
        return companyDao.findById(id);
    }

    @Override
    public void save(Company company) {
        company.setId(UUID.randomUUID().toString());
        company.setBalance(0.0);
        company.setState(0);
        companyDao.save(company);
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
    public PageInfo findByPage(int page, int size) {
        //首先查询总记录数
        //long count = companyDao.findCount();

        //使用pageHelper分页插件
        PageHelper.startPage(1, 5);
        //然后查询数据列表
        List list = companyDao.findByPage((page - 1) * size, size);
        //构造返回的分页对象
        //PageResult pageResult = new PageResult(count, list, page, size);
        return new PageInfo(list);
    }
}
