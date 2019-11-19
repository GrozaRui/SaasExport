package com.rui.service.system;

import com.github.pagehelper.PageInfo;
import com.rui.domain.system.User;

public interface UserService {

    //分页查询所有用户信息
    PageInfo findAllUser(int page, int size, String companyId);

    //根据id查询用户信息
    User findUserById(String id);

    //新增用户信息
    void save(User user);

    //修改用户信息
    void update(User user);

    //删除用户信息
    void delete(String id);
}
