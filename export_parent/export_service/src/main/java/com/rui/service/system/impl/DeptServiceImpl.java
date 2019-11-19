package com.rui.service.system.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rui.dao.system.DeptDao;
import com.rui.domain.system.Dept;
import com.rui.service.system.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @description:
 * @author: caihongrui
 * @createtime: 2019-11-18 15:59
 **/
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao deptDao;

    @Override
    public PageInfo findAllDept(int page, int size, String companyId) {
        //分页查询
        PageHelper.startPage(page, size);
        //按照公司id查询所有部门
        List list = deptDao.findAllDept(companyId);
        return new PageInfo(list);
    }

    @Override
    public List<Dept> findAllDept(String companyId) {
        return deptDao.findAllDept(companyId);
    }

    @Override
    public Dept findDeptById(String id) {
        return deptDao.findDeptById(id);
    }

    @Override
    public void save(Dept dept) {
        //保存操作 对象是没有id的 设置一个随机UUID
        dept.setId(UUID.randomUUID().toString());
        deptDao.save(dept);
    }

    @Override
    public void update(Dept dept) {
        deptDao.update(dept);
    }

    @Override
    public void delete(String id) {
        deptDao.delete(id);
    }
}
