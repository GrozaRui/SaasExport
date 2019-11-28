package com.rui.web.controller.cargo;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.rui.domain.cargo.Contract;
import com.rui.domain.cargo.ContractExample;
import com.rui.domain.system.User;
import com.rui.service.cargo.ContractService;
import com.rui.web.controller.BaseController;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description: 购销合同管理
 * @author: caihongrui
 * @createtime: 2019-11-25 16:50
 **/
@Controller
@RequestMapping("/cargo/contract")
public class ContractController extends BaseController {

    @Reference
    private ContractService contractService;

    /**
     * 分页查询购销合列表
     * @param page
     * @param size
     * @return
     */
    @RequestMapping("/list")
    public String list(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5") int size) {
        ContractExample contractExample = new ContractExample();
        ContractExample.Criteria criteria = contractExample.createCriteria();
        criteria.andCompanyIdEqualTo(companyId);

        /*
         * 细粒度权限控制
         *      1.获取当前用户的级别
         *      2.根据不用用户的级别添加不同的查询条件
         */
        User user = getLoginUser();
        Integer degree = user.getDegree();
        if(degree == 4) { //4-普通员工
            criteria.andCreateByEqualTo(user.getId());
        }else if(degree ==3) { //管理本部门 (经理：部门id)
            criteria.andCreateDeptEqualTo(user.getDeptId());
        }else if(degree ==2 ) {//2-管理所有下属部门和人员
            criteria.andCreateDeptLike(user.getDeptId()+"%");
        }

        //根据创建时间排序
        contractExample.setOrderByClause("create_time desc");
        PageInfo pageInfo = contractService.findAll(contractExample, page, size);
        request.setAttribute("page",pageInfo);
        return "/cargo/contract/contract-list";
    }

    /**
     * 跳转到添加合同页面
     * @return
     */
    @RequestMapping(value = "/toAdd",name = "跳转到添加合同页面")
    public String toAdd() {
        return "cargo/contract/contract-add";
    }

    /**
     * 跳转到修改合同页面
     */
    @RequestMapping(value = "/toUpdate", name = "跳转到修改合同页面")
    public String toUpdate(String id) {
        Contract contract = contractService.findContractById(id);
        request.setAttribute("contract", contract);
        return "cargo/contract/contract-update";
    }

    @RequestMapping(value = "edit", name = "添加/修改合同信息")
    public String edit(Contract contract) {
        contract.setCompanyId(companyId);
        contract.setCompanyName(companyName);
        if (StringUtils.isEmpty(contract.getId())) {
            //保存购销合同
            //获取当前登录用户
            User user = getLoginUser();
            //设置创建人和部门
            contract.setCreateBy(user.getId());
            contract.setCreateDept(user.getDeptId());
            contractService.save(contract);
        } else {
            contractService.update(contract);
        }
        return "redirect:/cargo/contract/list.do";
    }

    @RequestMapping(value = "/delete", name = "删除购销合同信息")
    public String delete(String id) {
        contractService.delete(id);
        return "redirect:/cargo/contract/list.do";
    }

    @RequestMapping(value = "/submit", name = "修改合同状态信息为提交")
    public String submit(String id) {
        Contract contract = new Contract();
        contract.setId(id);
        contract.setState(1);
        contractService.update(contract);
        return "redirect:/cargo/contract/list.do";
    }

    @RequestMapping(value = "/cancel", name = "修改合同状态信息为未提交")
    public String cancel(String id) {
        Contract contract = new Contract();
        contract.setId(id);
        contract.setState(0);
        contractService.update(contract);
        return "redirect:/cargo/contract/list.do";
    }

}
