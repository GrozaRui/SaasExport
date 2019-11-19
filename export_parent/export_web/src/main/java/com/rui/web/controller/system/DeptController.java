package com.rui.web.controller.system;

import com.github.pagehelper.PageInfo;
import com.rui.domain.system.Dept;
import com.rui.service.system.DeptService;
import com.rui.web.controller.BaseController;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @description: 系统管理  --> 部门管理
 * @author: caihongrui
 * @createtime: 2019-11-18 15:58
 **/
@Controller
@RequestMapping("/system/dept")
public class DeptController extends BaseController {

    @Autowired
    private DeptService deptService;

    /**
     * 分页查询部门列表
     * @return
     */
    @RequestMapping("/list")
    public String list(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5") int size) {
        //调用service层查询 根据当前登录用户的公司id查询
        PageInfo pageInfo = deptService.findAllDept(page, size, super.companyId);
        //将分页查询返回结果存入request域
        request.setAttribute("page", pageInfo);
        return "/system/dept/dept-list";
    }

    @RequestMapping("/toAdd")
    public String toAdd() {
        //查询所有部门 构造下拉框
        List<Dept> list = deptService.findAllDept(companyId);
        request.setAttribute("deptList", list);
        return "system/dept/dept-add";
    }

    @RequestMapping("/toUpdate")
    public String toUpdate(String id) {
        if (id == null && "".equals(id)) {
            System.out.println("错误信息 DeptController.toUpdate");
            return "";
        }
        //先根据id查询当前修改部门
        Dept dept = deptService.findDeptById(id);
        request.setAttribute("dept", dept);
        //然后查询所有部门
        List<Dept> deptList = deptService.findAllDept(companyId);
        request.setAttribute("deptList", deptList);
        return "/system/dept/dept-update";
    }

    @RequestMapping("/edit")
    public String edit(Dept dept) {
        dept.setCompanyId(companyId);
        dept.setCompanyName(companyName);
        //判断是否具有id
        if (StringUtils.isEmpty(dept.getId())) {
            deptService.save(dept);
        } else {
            deptService.update(dept);
        }
        return "redirect:/system/dept/list.do";
    }

    @RequestMapping("/delete")
    public String delete(String id) {
        if (id == null && "".equals(id)) {
            System.out.println("错误信息 DeptController.delete");
            return "";
        }
        deptService.delete(id);
        return "redirect:/system/dept/list.do";
    }
}
