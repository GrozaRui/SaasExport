package com.rui.service.export;

import com.github.pagehelper.PageInfo;
import com.rui.domain.export.Export;
import com.rui.domain.export.ExportExample;
import org.springframework.data.domain.Example;

/**
 * @description: dubbo远程调用接口 : 报运单功能
 * @author: caihongrui
 * @createtime: 2019-11-29 10:48
 **/
public interface ExportService {

    void save(Export export);

    void update(Export export);

    void delete(String id);

    PageInfo findAll(ExportExample exportExample, int page, int size);

    Export findById(String id);
}
