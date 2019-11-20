package com.rui.web.controller.system;

import com.github.pagehelper.PageInfo;
import com.rui.domain.system.Role;
import com.rui.service.system.RoleService;
import com.rui.web.controller.BaseController;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @description: 系统管理 --> 角色管理
 * @author: caihongrui
 * @createtime: 2019-11-19 17:28
 **/
@Controller
@RequestMapping("/system/role")
public class RoleController extends BaseController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("/list")
    public String list(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5") int size) {
        //调用service层分页查询所有角色信息
        PageInfo pageInfo = roleService.findAllRole(page, size, companyId);
        request.setAttribute("page", pageInfo);
        return "/system/role/role-list";
    }

    @RequestMapping("/toAdd")
    public String toAdd() {
        return "/system/role/role-add";
    }

    @RequestMapping("/toUpdate")
    public String toUpdate(String id) {
        //查询角色信息回显
        Role role = roleService.findRoleById(id);
        request.setAttribute("role", role);
        return "/system/role/role-update";
    }

    @RequestMapping("/edit")
    public String edit(Role role) {
        role.setCompanyId(companyId);
        role.setCompanyName(companyName);
        if (StringUtils.isEmpty(role.getId())) {
            roleService.save(role);
        } else {
            roleService.update(role);
        }
        return "redirect:/system/role/list.do";
    }

    @RequestMapping("/delete")
    public String delete(String id) {
        if (id != null && !"".equals(id)) {
            roleService.delete(id);
        }
        return "redirect:/system/role/list.do";
    }

}
