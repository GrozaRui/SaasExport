package com.rui.service.cargo;

import com.github.pagehelper.PageInfo;
import com.rui.domain.cargo.ContractProduct;
import com.rui.domain.cargo.ContractProductExample;
import com.rui.domain.cargo.ContractProductVo;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ContractProductService {

    //分页查询购销合同下的货物列表
    PageInfo findAll(ContractProductExample example, int page, int size);

    //根据货物id查询当前货物信息
    ContractProduct findProductById(String id);

    void save(ContractProduct contractProduct);

    void update(ContractProduct contractProduct);

    void delete(String id);

    //批量保存excel货物数据
    void saveAll(List<ContractProduct> list);

    //根据船期查询并封装为vo对象
    List<ContractProductVo> findVoByShipTime(String inputDate, String companyId);

}
