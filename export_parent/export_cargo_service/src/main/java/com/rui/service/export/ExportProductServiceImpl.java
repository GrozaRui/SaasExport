package com.rui.service.export;

import com.alibaba.dubbo.config.annotation.Service;
import com.rui.dao.export.ExportProductDao;
import com.rui.domain.export.ExportProduct;
import com.rui.domain.export.ExportProductExample;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @description: 报运单 货物管理接口实现类
 * @author: caihongrui
 * @createtime: 2019-11-29 15:30
 **/
@Service
public class ExportProductServiceImpl implements ExportProductService {

    @Autowired
    private ExportProductDao exportProductDao;

    @Override
    public List<ExportProduct> findAll(ExportProductExample example) {
        return exportProductDao.selectByExample(example);
    }

}
