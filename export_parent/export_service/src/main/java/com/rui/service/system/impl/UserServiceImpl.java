package com.rui.service.system.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rui.dao.system.UserDao;
import com.rui.domain.system.User;
import com.rui.service.system.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @description:
 * @author: caihongrui
 * @createtime: 2019-11-19 15:14
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public PageInfo findAllUser(int page, int size, String companyId) {
        //分页查询
        PageHelper.startPage(page, size);
        //调用dao层查询所有用户信息
        List userList = userDao.findAllUser(companyId);
        return new PageInfo(userList);
    }

    @Override
    public User findUserById(String id) {
        //调用dao层查询用户信息
        User user = userDao.findUserById(id);
        return user;
    }

    @Override
    public void save(User user) {
        //设置用户id
        user.setId(UUID.randomUUID().toString());
        userDao.save(user);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public void delete(String id) {
        userDao.delete(id);
    }

    @Override
    public void changeRole(String userid, String[] roleIds) {
        //根据用户id删除全部角色数据
        userDao.deleteUserrole(userid);
        //遍历数组 添加所有的角色数据
        for (String roleId : roleIds) {
            userDao.saveUserRole(userid, roleId);
        }
    }

    @Override
    public User findUserByEmail(String email) {
        return userDao.findUserByEmail(email);
    }

}
