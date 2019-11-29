package com.rui.dao.cargo;

import com.rui.domain.cargo.ContractProduct;
import com.rui.domain.cargo.ContractProductExample;
import com.rui.domain.cargo.ContractProductVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ContractProductDao {

    int deleteByPrimaryKey(String id);

    void deleteByContractId(String id);

    int insert(ContractProduct record);

    int insertSelective(ContractProduct record);

    List<ContractProduct> selectByExample(ContractProductExample example);

    ContractProduct selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ContractProduct record);

    int updateByPrimaryKey(ContractProduct record);

    //根据船期查询并封装为vo对象
    List<ContractProductVo> findByShipTime(@Param("shipTime") String inputDate, @Param("companyId")String companyId);
}