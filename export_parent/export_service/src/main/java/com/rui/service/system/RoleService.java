package com.rui.service.system;

import com.github.pagehelper.PageInfo;
import com.rui.domain.system.Role;

import java.util.List;

public interface RoleService {

    //分页查询所有角色信息
    PageInfo findAllRole(int page, int size, String companyId);

    //重载 根据公司id查询所有角色信息
    List findAllRole(String companyId);

    //根据主键id查询角色信息
    Role findRoleById(String id);

    //新增角色信息
    void save(Role role);

    //修改角色信息
    void update(Role role);

    //删除角色信息
    void delete(String id);

    //修改角色的模块权限信息
    void updateRoleModule(String roleId, String moduleIds);

    //(用户角色中间表)根据用户id查询所有角色信息
    List<Role> findRoleByUserId(String id);
}
