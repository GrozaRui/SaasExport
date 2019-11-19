package com.rui.web.controller.compnay;

import com.github.pagehelper.PageInfo;
import com.rui.domain.company.Company;
import com.rui.entity.PageResult;
import com.rui.service.company.CompanyService;
import com.rui.web.controller.BaseController;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/company")
public class CompanyController extends BaseController {

    @Autowired
    private CompanyService companyService;

    //查询所有
    @RequestMapping("/list")
    public String list(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5") int size) {
        //利用分页对象进行分页查询
        PageInfo pageInfo = companyService.findByPage(page, size);
        System.out.println("进入findAll方法");
        //List<Company> list = companyService.findAll();
        //request.setAttribute("companyList", list);
        request.setAttribute("page",pageInfo);
        return "company/company-list";
    }

    //根据id查询
    @RequestMapping("/findById")
    public String findById(String id) {
        if (id != null && !"".equals(id)) {
            Company company = companyService.findById(id);
            request.setAttribute("company",company);
        }
        return "redirect:/company/list.do";
    }

    //跳转新增页面
    @RequestMapping("/toAdd")
    public String toAdd() {
        return "/company/company-add";
    }

    //跳转修改页面
    @RequestMapping("/toUpdate")
    public String toUpdate(String id) {
        if (id != null && !"".equals(id)) {
            System.out.println("进入 companyConroller.toUpdate");
            Company company = companyService.findById(id);
            request.setAttribute("company",company);
        }
        return "/company/company-update";
    }

    // 保存数据/修改数据
    @RequestMapping("/edit")
    public String edit(Company company) {
        if (StringUtils.isEmpty(company.getId())) {
            companyService.save(company);
        } else {
            companyService.update(company);
        }
        return "redirect:/company/list.do";
    }

    //删除数据
    @RequestMapping("/delete")
    public String delete(String id) {
        if (id != null && !"".equals(id)) {
            companyService.delete(id);
        }
        return "redirect:/company/list.do";
    }
}
