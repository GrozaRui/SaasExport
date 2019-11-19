package com.rui.service.system;

import com.github.pagehelper.PageInfo;
import com.rui.domain.system.Dept;

import java.util.List;

public interface DeptService  {

    //分页查询部门列表
    PageInfo findAllDept(int page, int size, String companyId);

    //根据companyId 查询所有部门
    List<Dept> findAllDept(String companyId);

    //根据deptId查询部门
    Dept findDeptById(String id);

    //新增部门信息
    void save(Dept dept);

    //修改部门信息
    void update(Dept dept);

    //删除部门信息
    void delete(String id);
}
