package com.rui.web.controller.compnay;

import com.rui.domain.company.Company;
import com.rui.service.company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    //查询所有
    @RequestMapping("/findAll")
    public String findAll(HttpServletRequest request) {
        System.out.println("进入findAll方法");
        List<Company> list = companyService.findAll();
        System.out.println("list == " + list);
        request.setAttribute("companyList", list);
        return "company/company-list";
    }
}
