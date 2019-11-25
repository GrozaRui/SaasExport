package com.rui.service.system.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rui.dao.system.SysLogDao;
import com.rui.domain.system.SysLog;
import com.rui.service.system.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @description:
 * @author: caihongrui
 * @createtime: 2019-11-21 11:14
 **/
@Service
public class SysLogServiceImpl implements SysLogService {
    @Autowired
    private SysLogDao sysLogDao;

    @Override
    public PageInfo findAll(int page, int size, String companyId) {
        PageHelper.startPage(page, size);
        List<SysLog> list = sysLogDao.findAll(companyId);
        return new PageInfo(list);
    }

    @Override
    public void save(SysLog log) {
        log.setId(UUID.randomUUID().toString());
        sysLogDao.save(log);
    }
}
