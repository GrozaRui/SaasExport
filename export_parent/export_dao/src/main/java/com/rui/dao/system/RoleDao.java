package com.rui.dao.system;

import com.rui.domain.system.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleDao {

    //分页查询所有角色信息
    List findAllRole(String companyId);

    //根据主键id查询角色信息
    Role findRoleById(String id);

    //新增角色信息
    void save(Role role);

    //修改角色信息
    void update(Role role);

    //删除角色信息
    void delete(String id);

    //删除当前角色的所有模块信息
    void deleteRolemodule(String roleId);

    //(在角色模块中间表)新增当前角色的模块权限信息
    void saveRoleModule(@Param("roleId") String roleId, @Param("moduleId") String moduleId);
}
