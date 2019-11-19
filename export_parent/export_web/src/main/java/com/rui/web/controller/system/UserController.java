package com.rui.web.controller.system;

import com.github.pagehelper.PageInfo;
import com.rui.domain.system.Dept;
import com.rui.domain.system.User;
import com.rui.service.system.DeptService;
import com.rui.service.system.UserService;
import com.rui.web.controller.BaseController;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @description: 系统管理 --> 用户管理
 * @author: caihongrui
 * @createtime: 2019-11-19 15:05
 **/
@Controller
@RequestMapping("/system/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @Autowired
    private DeptService deptService;

    /**
     * 分页查询所有用户信息
     * @param page
     * @param size
     * @return
     */
    @RequestMapping("/list")
    public String list(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5") int size) {
        //调动service层,根据当前登录用户的companyId来查询所属用户信息
        PageInfo pageInfo = userService.findAllUser(page, size, companyId);
        //将用户信息存入request域
        request.setAttribute("page", pageInfo);
        return "/system/user/user-list";
    }

    /**
     * 跳转用户新增页面
     */
    @RequestMapping("toAdd")
    public String toAdd() {
        //查询所有部门,构造下拉框数据
        List<Dept> deptList = deptService.findAllDept(companyId);
        request.setAttribute("deptList", deptList);
        return "/system/user/user-add";
    }

    /**
     * 跳转用户修改页面
     */
    @RequestMapping("/toUpdate")
    public String toUpdate(String id) {
        //查询所有部门,构造下拉框数据
        List<Dept> deptList = deptService.findAllDept(companyId);
        request.setAttribute("deptList", deptList);
        //查询用户回显数据
        User user = userService.findUserById(id);
        request.setAttribute("user",user);
        return "/system/user/user-update";
    }

    /**
     * 新增/修改用户信息
     */
    @RequestMapping("/edit")
    public String edit(User user) {
        //设置用户所属公司信息
        user.setCompanyId(companyId);
        user.setCompanyName(super.companyName);
        //判断
        if (StringUtils.isEmpty(user.getId())) {
            userService.save(user);
        } else {
            userService.update(user);
        }
        return "redirect:/system/user/list.do";
    }

    /**
     * 删除用户信息
     */
    @RequestMapping("/delete")
    public String delete(String id) {
        if (id != null && !"".equals(id)) {
            userService.delete(id);
        }
        return "redirect:/system/user/list.do";
    }
}
