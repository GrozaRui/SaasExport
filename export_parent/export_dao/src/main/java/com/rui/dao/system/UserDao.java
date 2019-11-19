package com.rui.dao.system;

import com.rui.domain.system.User;

import java.util.List;

public interface UserDao {

    //分页查询所有用户
    List findAllUser(String companyId);

    //根据用户id查询用户信息
    User findUserById(String id);

    //新增用户信息
    void save(User user);

    //修改用户信息
    void update(User user);

    //删除用户信息
    void delete(String id);
}
