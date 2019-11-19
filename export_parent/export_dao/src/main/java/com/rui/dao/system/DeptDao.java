package com.rui.dao.system;

import com.rui.domain.system.Dept;

import java.util.List;

public interface DeptDao {

    //查询所有部门
    List findAllDept(String companyId);

    //根据id查询父部门信息
    Dept findDeptById(String id);

    //新增部门信息
    void save(Dept dept);

    //修改部门信息
    void update(Dept dept);

    //删除部门信息
    void delete(String id);
}
