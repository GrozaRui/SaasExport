package com.rui.service.cargo;

import com.alibaba.dubbo.config.annotation.Service;
import com.rui.dao.cargo.FactoryDao;
import com.rui.domain.cargo.Factory;
import com.rui.domain.cargo.FactoryExample;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @description: 购销合同 -> 工厂
 * @author: caihongrui
 * @createtime: 2019-11-26 16:20
 **/
@Service
public class FactoryServiceImpl implements FactoryService {

    @Autowired
    private FactoryDao factoryDao;

    @Override
    public List findAll(FactoryExample factoryExample) {
        List<Factory> factories = factoryDao.selectByExample(factoryExample);
        return factories;
    }

}
