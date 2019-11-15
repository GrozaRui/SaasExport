package com.rui.web.controller.compnay;

import com.rui.service.company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    //查询所有
    @RequestMapping("/findAll")
    public String findAll(HttpServletRequest request) {
        request.setAttribute("companyList", companyService.findAll());
        System.out.println("进入findAll方法");
        return "company/company-list";
    }
}
