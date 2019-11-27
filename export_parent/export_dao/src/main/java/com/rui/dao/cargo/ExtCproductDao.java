package com.rui.dao.cargo;

import com.rui.domain.cargo.ExtCproduct;
import com.rui.domain.cargo.ExtCproductExample;

import java.util.List;

public interface ExtCproductDao {

    List<ExtCproduct> findExtCproductByProductId(String id);

    int deleteByPrimaryKey(String id);

    void deleteByContractId(String id);

    int insert(ExtCproduct record);

    int insertSelective(ExtCproduct record);

    List<ExtCproduct> selectByExampleWithBLOBs(ExtCproductExample example);

    List<ExtCproduct> selectByExample(ExtCproductExample example);

    ExtCproduct selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ExtCproduct record);

    int updateByPrimaryKeyWithBLOBs(ExtCproduct record);

    int updateByPrimaryKey(ExtCproduct record);
}