package com.rui.service.system.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rui.dao.system.ModuleDao;
import com.rui.domain.system.Module;
import com.rui.service.system.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @description: 模块管理 业务层实现
 * @author: caihongrui
 * @createtime: 2019-11-20 10:28
 **/
@Service
public class ModuleServiceImpl implements ModuleService {

    @Autowired
    private ModuleDao moduleDao;

    @Override
    public PageInfo findAllModule(int page, int size) {
        PageHelper.startPage(page, size);
        //调用dao层查询模块信息
        List<Module> moduleList = moduleDao.findAllModule();
        return new PageInfo(moduleList);
    }

    @Override
    public List<Module> findAllModule() {
        List<Module> moduleList = moduleDao.findAllModule();
        return moduleList;
    }

    @Override
    public Module findModuleById(String id) {
        return moduleDao.findModuleById(id);
    }

    @Override
    public void save(Module module) {
        module.setId(UUID.randomUUID().toString());
        moduleDao.save(module);
    }

    @Override
    public void update(Module module) {
        moduleDao.update(module);
    }

    @Override
    public void delete(String id) {
        moduleDao.delete(id);
    }
}
