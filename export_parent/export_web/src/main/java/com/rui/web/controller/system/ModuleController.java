package com.rui.web.controller.system;

import com.github.pagehelper.PageInfo;
import com.rui.domain.system.Module;
import com.rui.service.system.ModuleService;
import com.rui.web.controller.BaseController;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @description: 系统管理 --> 模块管理 web层实现
 * @author: caihongrui
 * @createtime: 2019-11-20 10:32
 **/
@Controller
@RequestMapping("/system/module")
public class ModuleController extends BaseController {

    @Autowired
    private ModuleService moduleService;

    @RequestMapping(value = "list",name = "分页查询模块信息")
    public String list(@RequestParam(defaultValue = "1")int page, @RequestParam(defaultValue = "5")int size) {
        //调用service层查询
        PageInfo pageInfo = moduleService.findAllModule(page, size);
        //将返回的信息存入request域
        request.setAttribute("page", pageInfo);
        return "/system/module/module-list";
    }

    @RequestMapping(value = "toAdd", name = "跳转新增模块页面")
    public String toAdd() {
        //查询出所有模块
        List<Module> moduleList = moduleService.findAllModule();
        request.setAttribute("menus", moduleList);
        return "/system/module/module-add";
    }

    @RequestMapping(value = "toUpdate", name = "跳转修改模块页面")
    public String toUpdate(String id) {
        //查询出所有模块
        List<Module> moduleList = moduleService.findAllModule();
        request.setAttribute("menus", moduleList);
        //查询出当前修改模块对象
        Module module = moduleService.findModuleById(id);
        request.setAttribute("module",module);
        return "/system/module/module-update";
    }

    @RequestMapping(value = "edit",name = "新增/修改模块信息")
    public String edit(Module module) {
        if (StringUtils.isEmpty(module.getId())) {
            moduleService.save(module);
        } else {
            moduleService.update(module);
        }
        return "redirect:/system/module/list.do";
    }

    @RequestMapping(value = "delete",name = "删除模块信息")
    public String delete(String id) {
        moduleService.delete(id);
        return "redirect:/system/module/list.do";
    }


}
