package com.rui.service.system;

import com.github.pagehelper.PageInfo;
import com.rui.domain.system.Module;

import java.util.List;

public interface ModuleService {

    //分页查询模块信息
    PageInfo findAllModule(int page, int size);

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

    //根据角色id去 角色-模块表查询 对应的模块列表
    List<Module> findModuleByRoleId(String roleId);

    //根据用户id查询出可访问的模块列表
    List<Module> findModuleByUserId(String id);
}
