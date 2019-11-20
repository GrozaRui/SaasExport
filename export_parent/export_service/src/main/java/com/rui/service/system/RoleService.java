package com.rui.service.system;

import com.github.pagehelper.PageInfo;
import com.rui.domain.system.Role;

import java.util.List;

public interface RoleService {

    //分页查询所有角色信息
    PageInfo findAllRole(int page, int size, String companyId);

    //根据主键id查询角色信息
    Role findRoleById(String id);

    //新增角色信息
    void save(Role role);

    //修改角色信息
    void update(Role role);

    //删除角色信息
    void delete(String id);
}
