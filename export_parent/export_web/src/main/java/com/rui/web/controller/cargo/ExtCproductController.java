package com.rui.web.controller.cargo;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.rui.domain.cargo.ExtCproduct;
import com.rui.domain.cargo.ExtCproductExample;
import com.rui.domain.cargo.FactoryExample;
import com.rui.service.cargo.ExtCproductService;
import com.rui.service.cargo.FactoryService;
import com.rui.web.controller.BaseController;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @description: 购销合同 -> 附件 控制器
 * @author: caihongrui
 * @createtime: 2019-11-27 14:43
 **/
@Controller
@RequestMapping("/cargo/extCproduct")
public class ExtCproductController extends BaseController {

    @Reference
    private ExtCproductService extCproductService;

    @Reference
    private FactoryService factoryService;

    @RequestMapping(value = "/list", name = "分页查询货物下的附件信息列表")
    public String list(String contractId, String contractProductId,
                       @RequestParam(defaultValue = "1") int page,
                       @RequestParam(defaultValue = "5") int size) {
        //查询附件列表
        ExtCproductExample extCproductExample = new ExtCproductExample();
        extCproductExample.createCriteria().andContractProductIdEqualTo(contractProductId);
        PageInfo pageInfo = extCproductService.findAll(extCproductExample, page, size);
        request.setAttribute("page",pageInfo);
        //查询生产厂家 (附件)
        FactoryExample factoryExample = new FactoryExample();
        FactoryExample.Criteria criteria1 = factoryExample.createCriteria();
        criteria1.andCtypeEqualTo("附件");
        List factoryList = factoryService.findAll(factoryExample);
        request.setAttribute("factoryList",factoryList);
        //页面参数设置
        request.setAttribute("contractId", contractId);
        request.setAttribute("contractProductId", contractProductId);
        return "/cargo/extc/extc-list";
    }

    @RequestMapping(value = "/toUpdate", name = "跳转修改附件信息页面")
    public String toUpdate(String id, String contractId, String contractProductId) {
        //查询附件信息
        ExtCproduct extCproduct = extCproductService.findExtCproductById(id);
        request.setAttribute("extCproduct", extCproduct);
        //查询附件厂家信息
        FactoryExample factoryExample = new FactoryExample();
        factoryExample.createCriteria().andCtypeEqualTo("附件");
        List factoryList = factoryService.findAll(factoryExample);
        request.setAttribute("factoryList", factoryList);
        //页面参数
        request.setAttribute("contractId",contractId);
        request.setAttribute("contractProductId",contractProductId);
        return "/cargo/extc/extc-update";
    }

    @RequestMapping("/edit")
    public String edit(ExtCproduct extCproduct) {
        extCproduct.setCompanyId(companyId);
        extCproduct.setCompanyName(companyName);
        if (StringUtils.isEmpty(extCproduct.getId())) {
            extCproductService.save(extCproduct);
        } else {
            extCproductService.update(extCproduct);
        }
        return "redirect:/cargo/extCproduct/list.do?contractId=" + extCproduct.getContractId() + "&contractProductId=" + extCproduct.getContractProductId();
    }

    @RequestMapping("/delete")
    public String delete(String id, String contractId,String contractProductId) {
        extCproductService.delete(id);
        return "redirect:/cargo/extCproduct/list.do?contractId=" + contractId + "&contractProductId=" + contractProductId;
    }
}
