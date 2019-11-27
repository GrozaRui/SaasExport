package com.rui.service.cargo;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rui.dao.cargo.ContractDao;
import com.rui.dao.cargo.ContractProductDao;
import com.rui.dao.cargo.ExtCproductDao;
import com.rui.domain.cargo.Contract;
import com.rui.domain.cargo.ContractExample;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @description: 购销合同 服务提供者 业务实现
 * @author: caihongrui
 * @createtime: 2019-11-22 17:25
 **/

@Service
public class ContractServiceImpl implements ContractService {

    @Autowired
    private ContractDao contractDao;

    @Autowired
    private ContractProductDao contractProductDao;

    @Autowired
    private ExtCproductDao extCproductDao;

    @Override
    public PageInfo findAll(ContractExample example, int page, int size) {
        PageHelper.startPage(page, size);
        List<Contract> contractList = contractDao.selectByExample(example);
        return new PageInfo(contractList);
    }

    @Override
    public Contract findContractById(String id) {
        return contractDao.selectByPrimaryKey(id);
    }

    @Override
    public void save(Contract contract) {
        //保存时要对购销合同对象设置基本属性
        contract.setId(UUID.randomUUID().toString());
        contract.setState(0);
        contract.setCreateTime(new Date());
        contract.setProNum(0);
        contract.setExtNum(0);
        contract.setTotalAmount(new BigDecimal(0));
        contractDao.insertSelective(contract);
    }

    @Override
    public void update(Contract contract) {
        //同时使用主键和字段去查询对象
        contractDao.updateByPrimaryKeySelective(contract);
    }

    @Override
    public void delete(String id) {
        //删除购销合同信息
        contractDao.deleteByPrimaryKey(id);
        //删除购销合同下的货物信息
        contractProductDao.deleteByContractId(id);
        //删除购销合同下的附件货物信息
        extCproductDao.deleteByContractId(id);
    }


}
