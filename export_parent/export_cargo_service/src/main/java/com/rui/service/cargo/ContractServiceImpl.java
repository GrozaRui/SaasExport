package com.rui.service.cargo;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rui.dao.cargo.ContractDao;
import com.rui.domain.cargo.Contract;
import com.rui.domain.cargo.ContractExample;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @description:
 * @author: caihongrui
 * @createtime: 2019-11-22 17:25
 **/

@Service
public class ContractServiceImpl implements ContractService {

    @Autowired
    private ContractDao contractDao;

    @Override
    public PageInfo findAll(ContractExample example, int page, int size) {
        PageHelper.startPage(page, size);
        List<Contract> contractList = contractDao.selectByExample(example);
        return new PageInfo(contractList);
    }
}
