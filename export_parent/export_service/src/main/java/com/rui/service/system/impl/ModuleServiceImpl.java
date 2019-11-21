package com.rui.service.system.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rui.dao.system.ModuleDao;
import com.rui.dao.system.UserDao;
import com.rui.domain.system.Module;
import com.rui.domain.system.User;
import com.rui.service.system.ModuleService;
import com.rui.service.system.UserService;
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

    @Autowired
    private UserDao userDao;

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

    @Override
    public List<Module> findModuleByRoleId(String roleId) {
        return moduleDao.findModuleByRoleId(roleId);
    }

    @Override
    public List<Module> findModuleByUserId(String id) {
        //查询用户
        User user = userDao.findUserById(id);
        //获取用户degree等级
        Integer degree = user.getDegree();
        //根据用户degree查询对应的模块列表 0 => 查询belong=0的所有菜单  1 => belong=1的菜单 其他=>根据权限五表查询用户对应模块菜单
        if (degree == 0) {
            return moduleDao.findModuleByBelong(0);
        } else if (degree == 1) {
            return moduleDao.findModuleByBelong(1);
        } else {
            return moduleDao.findModuleByUserId(id);
        }
    }
}
