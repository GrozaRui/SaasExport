package com.rui.dao.system;

import com.rui.domain.system.Module;

import java.util.List;

public interface ModuleDao {

    //查询所有模块信息
    List<Module> findAllModule();

    //根据模块id查询模块信息
    Module findModuleById(String id);

    //新增模块信息
    void save(Module module);

    //修改模块信息
    void update(Module module);

    //删除模块信息
    void delete(String id);

    //根据角色id去 角色-模块中间表 查询对应的模块信息
    List<Module> findModuleByRoleId(String roleId);
}
