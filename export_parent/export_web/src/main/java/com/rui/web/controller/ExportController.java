package com.rui.web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.rui.domain.cargo.ContractExample;
import com.rui.domain.export.Export;
import com.rui.domain.export.ExportExample;
import com.rui.domain.export.ExportProduct;
import com.rui.domain.export.ExportProductExample;
import com.rui.service.cargo.ContractService;
import com.rui.service.export.ExportProductService;
import com.rui.service.export.ExportService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @description: 报运单功能 控制器
 * @author: caihongrui
 * @createtime: 2019-11-29 10:44
 **/
@Controller
@RequestMapping("/cargo/export")
public class ExportController extends BaseController {

    @Reference
    private ContractService contractService;

    @Reference
    private ExportService exportService;

    @Reference
    private ExportProductService exportProductService;


    @RequestMapping("/contractList")
    public String contractList(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5") int size) {
        ContractExample contractExample = new ContractExample();
        ContractExample.Criteria criteria = contractExample.createCriteria();
        criteria.andCompanyIdEqualTo(companyId);
        criteria.andStateEqualTo(1);
        contractExample.setOrderByClause("create_time desc");
        PageInfo pageInfo = contractService.findAll(contractExample, page, size);
        request.setAttribute("page", pageInfo);
        return "/cargo/export/export-contractList";
    }

    @RequestMapping(value = "/toExport",name = "跳转到报运单页面")
    public String toExport(String id) {
        request.setAttribute("id",id);
        return "/cargo/export/export-toExport";
    }

    @RequestMapping("/edit")
    public String edit(Export export) {
        export.setCompanyId(companyId);
        export.setCompanyName(companyName);
        if (StringUtils.isEmpty(export.getId())) {
            exportService.save(export);
        } else {
            exportService.update(export);
        }
        return "redirect:/cargo/export/list.do";
    }


    /**
     * 构造报运单商品列表：
     *      方式一：配置一对多的关联查询
     *      方拾二：直接查询商品表
     */
    @RequestMapping("/toUpdate")
    public String toUpdate(String id) {
        //1.根据id查询报运单
        Export export = exportService.findById(id);
        request.setAttribute("export",export);
        //2.根据报运单id查询所有商品
        ExportProductExample example = new ExportProductExample();
        ExportProductExample.Criteria criteria = example.createCriteria();
        criteria.andExportIdEqualTo(id);
        List<ExportProduct> eps = exportProductService.findAll(example);
        request.setAttribute("eps",eps);
        return "/cargo/export/export-update";
    }

    /**
     * 报运列表
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping("/list")
    public String list(@RequestParam(defaultValue = "1") Integer page , @RequestParam(defaultValue = "5")  Integer pageSize){
        //查询所有的报运列表数据 企业id
        ExportExample example = new  ExportExample();
        ExportExample.Criteria criteria = example.createCriteria();
        criteria.andCompanyIdEqualTo(super.companyId);
        PageInfo pageInfo = exportService.findAll(example, page, pageSize);
        request.setAttribute("page" , pageInfo);
        return "cargo/export/export-list";
    }

    @RequestMapping("/delete")
    public String delete(String id) {
        exportService.delete(id);
        return "redirect:/cargo/export/list.do";
    }
}
