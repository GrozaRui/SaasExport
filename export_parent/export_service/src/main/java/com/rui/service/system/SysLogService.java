package com.rui.service.system;

import com.github.pagehelper.PageInfo;
import com.rui.domain.system.SysLog;

public interface SysLogService {

    //分页查询所有日志信息
    PageInfo findAll(int page, int size, String companyId);

    void save(SysLog sysLog);

}
