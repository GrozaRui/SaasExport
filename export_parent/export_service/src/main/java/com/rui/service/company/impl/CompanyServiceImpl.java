package com.rui.service.company.impl;

import com.rui.dao.company.CompanyDao;
import com.rui.domain.company.Company;
import com.rui.service.company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public void insert(Company company) {

    }
}
