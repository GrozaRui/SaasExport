package com.rui.web.controller.system;

import com.github.pagehelper.PageInfo;
import com.rui.domain.system.Dept;
import com.rui.domain.system.Role;
import com.rui.domain.system.User;
import com.rui.service.system.DeptService;
import com.rui.service.system.RoleService;
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
    private RoleService roleService;

    @Autowired
    private DeptService deptService;

    /**
     * 分页查询所有用户信息
     * @param page
     * @param size
     * @return
     */
    @RequestMapping(value = "/list",name = "分页查询用户信息")
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
    @RequestMapping(value = "toAdd",name = "跳转到用户新增页面")
    public String toAdd() {
        //查询所有部门,构造下拉框数据
        List<Dept> deptList = deptService.findAllDept(companyId);
        request.setAttribute("deptList", deptList);
        return "/system/user/user-add";
    }

    /**
     * 跳转用户修改页面
     */
    @RequestMapping(value = "/toUpdate",name = "跳转到用户修改页面")
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
    @RequestMapping(value = "/edit",name = "新增/修改用户信息")
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
    @RequestMapping(value = "/delete",name = "删除用户信息")
    public String delete(String id) {
        if (id != null && !"".equals(id)) {
            userService.delete(id);
        }
        return "redirect:/system/user/list.do";
    }

    /**
     * 跳转用户的角色分配页面 回显数据
     */
    @RequestMapping(value = "/roleList",name = "跳转到用户的角色分配页面")
    public String toRoleList(String id) {
        //查询出当前用户
        User user = userService.findUserById(id);
        request.setAttribute("user", user);
        //查询出所有角色信息
        List<Role> roleList = roleService.findAllRole(companyId);
        request.setAttribute("roleList", roleList);
        //查询出当前用户的所有角色信息
        List<Role> userRoleList = roleService.findRoleByUserId(id);
        //构造字符串 保存有用户所拥有的角色的id
        StringBuilder stringBuilder = new StringBuilder();
        for (Role role : userRoleList) {
            stringBuilder.append(role.getId());
            stringBuilder.append(",");
        }
        request.setAttribute("userRoleStr", stringBuilder.toString());
        return "system/user/user-role";
    }

    /**
     * 修改用户的角色信息
     * 向后台传递的参数 如果有多个相同名称的input对象 可在后台直接封装为数组
     */
    @RequestMapping(value = "/changeRole",name = "修改用户的对应角色信息")
    public String changeRole(String userid, String[] roleIds) {
        userService.changeRole(userid, roleIds);
        return "redirect:/system/user/list.do";
    }
}
