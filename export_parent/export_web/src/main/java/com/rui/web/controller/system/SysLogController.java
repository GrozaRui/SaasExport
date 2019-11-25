package com.rui.web.controller.system;

import com.github.pagehelper.PageInfo;
import com.rui.service.system.SysLogService;
import com.rui.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @description: 系统管理 --> 日志管理
 * @author: caihongrui
 * @createtime: 2019-11-21 11:15
 **/
@Controller
@RequestMapping("/system/log")
public class SysLogController extends BaseController {

    @Autowired
    private SysLogService sysLogService;

    @RequestMapping(value = "/list",name = "分页查询所有的日志信息")
    public String list(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5")int size) {
        PageInfo info = sysLogService.findAll(page, size,super.companyId);
        request.setAttribute("page",info);
        return "system/log/log-list";
    }
}
