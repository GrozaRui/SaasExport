package com.rui.dao.export;

import com.rui.domain.export.Export;
import com.rui.domain.export.ExportExample;

import java.util.List;

public interface ExportDao {
    int deleteByPrimaryKey(String id);

    int insert(Export record);

    int insertSelective(Export record);

    List<Export> selectByExample(ExportExample example);

    Export selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Export record);

    int updateByPrimaryKey(Export record);
}