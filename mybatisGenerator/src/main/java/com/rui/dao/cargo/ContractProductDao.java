package com.rui.dao.cargo;

import com.rui.domain.cargo.ContractProduct;
import com.rui.domain.cargo.ContractProductExample;
import java.util.List;

public interface ContractProductDao {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table co_contract_product
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table co_contract_product
     *
     * @mbg.generated
     */
    int insert(ContractProduct record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table co_contract_product
     *
     * @mbg.generated
     */
    int insertSelective(ContractProduct record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table co_contract_product
     *
     * @mbg.generated
     */
    List<ContractProduct> selectByExample(ContractProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table co_contract_product
     *
     * @mbg.generated
     */
    ContractProduct selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table co_contract_product
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(ContractProduct record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table co_contract_product
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(ContractProduct record);
}