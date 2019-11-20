package com.rui.service.system.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rui.dao.system.RoleDao;
import com.rui.domain.system.Role;
import com.rui.service.system.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @description:
 * @author: caihongrui
 * @createtime: 2019-11-19 17:27
 **/
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public PageInfo findAllRole(int page, int size, String companyId) {
        PageHelper.startPage(page, size);
        //调用dao层查询角色信息
        List roleList = roleDao.findAllRole(companyId);
        return new PageInfo(roleList);
    }

    @Override
    public Role findRoleById(String id) {
        return roleDao.findRoleById(id);
    }

    @Override
    public void save(Role role) {
        role.setId(UUID.randomUUID().toString());
        roleDao.save(role);
    }

    @Override
    public void update(Role role) {
        roleDao.update(role);
    }

    @Override
    public void delete(String id) {
        roleDao.delete(id);
    }
}
