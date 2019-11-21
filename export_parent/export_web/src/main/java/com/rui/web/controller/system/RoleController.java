package com.rui.web.controller.system;

import com.github.pagehelper.PageInfo;
import com.rui.domain.system.Module;
import com.rui.domain.system.Role;
import com.rui.service.system.ModuleService;
import com.rui.service.system.RoleService;
import com.rui.web.controller.BaseController;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Autowired
    private ModuleService moduleService;

    //分页查询角色列表
    @RequestMapping(value = "/list",name = "分页查询所有角色信息")
    public String list(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5") int size) {
        //调用service层分页查询所有角色信息
        PageInfo pageInfo = roleService.findAllRole(page, size, companyId);
        request.setAttribute("page", pageInfo);
        return "/system/role/role-list";
    }

    //跳转新增角色页面
    @RequestMapping(value = "/toAdd",name = "跳转新增角色信息页面")
    public String toAdd() {
        return "/system/role/role-add";
    }

    //跳转修改角色页面
    @RequestMapping("/toUpdate")
    public String toUpdate(String id) {
        //查询角色信息回显
        Role role = roleService.findRoleById(id);
        request.setAttribute("role", role);
        return "/system/role/role-update";
    }

    //新增或修改角色信息
    @RequestMapping(value = "/edit",name = "新增或修改角色信息")
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

    //删除角色信息
    @RequestMapping(value = "/delete",name = "删除角色信息")
    public String delete(String id) {
        if (id != null && !"".equals(id)) {
            roleService.delete(id);
        }
        return "redirect:/system/role/list.do";
    }


    //跳转角色的权限信息页面
    @RequestMapping(value = "/roleModule",name = "跳转到角色的模块权限页面")
    public String toRoleModule(String roleId) {
        //查询出当前角色的信息
        Role role = roleService.findRoleById(roleId);
        request.setAttribute("role", role);
        return "/system/role/role-module";
    }

    /**
     * 初始化角色的权限树形结构
     */
    @RequestMapping(value = "/getZtreeNodes",name = "初始化角色的权限树形结构")
    @ResponseBody  //将对象自动转换为json字符串
    public List<Map> getZtreeNodes(String roleId) {
        //查询出所有的模块信息
        List<Module> moduleList = moduleService.findAllModule();
        //用户-模块表 查询用户所对应的模块信息
        List<Module> roleModuleList = moduleService.findModuleByRoleId(roleId);

        //构造对应的返回值
        List<Map> treeMap = new ArrayList<>();
        //数据部分 { id:11, pId:1, name:"随意勾选 1-1", open:true , checked : checked}
        for (Module module : moduleList) {
            Map map = new HashMap();
            map.put("id", module.getId());
            map.put("pId", module.getParentId());
            map.put("name", module.getName());

            //判断是否属性设为checked
            if (roleModuleList.contains(module)) {
                map.put("checked", "true");
            }
            treeMap.add(map);
        }
        return treeMap;
    }

    /**
     * 修改角色的模块权限数据
     * roleId    :  xxxxx
     * moduleIds : 2,201,202,203,204,205,206,207,208,3,301,302
     */
    @RequestMapping(value = "/updateRoleModule",name = "修改角色的模块权限信息")
    public String updateRoleModule(String roleId, String moduleIds) {
        roleService.updateRoleModule(roleId, moduleIds);
        return "redirect:/system/role/list.do";
    }

}
