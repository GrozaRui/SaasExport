package com.rui.service.cargo;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rui.dao.cargo.ContractDao;
import com.rui.dao.cargo.ContractProductDao;
import com.rui.dao.cargo.ExtCproductDao;
import com.rui.domain.cargo.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

/**
 * @description: 购销合同 -> 货物
 * @author: caihongrui
 * @createtime: 2019-11-26 16:11
 **/
@Service
public class ContractProductServiceImpl implements ContractProductService {

    @Autowired
    private ContractDao contractDao;

    @Autowired
    private ContractProductDao contractProductDao;

    @Autowired
    private ExtCproductDao extCproductDao;

    @Override
    public PageInfo findAll(ContractProductExample example, int page, int size) {
        PageHelper.startPage(page, size);
        List<ContractProduct> contractProductList = contractProductDao.selectByExample(example);
        return new PageInfo<>(contractProductList);
    }

    @Override
    public ContractProduct findProductById(String id) {
        return contractProductDao.selectByPrimaryKey(id);
    }

    @Override
    public void save(ContractProduct contractProduct) {
        //设置id
        contractProduct.setId(UUID.randomUUID().toString());
        BigDecimal productTotalAmount = new BigDecimal(0);
        if (contractProduct.getCnumber() != null && contractProduct.getPrice() != null) {
            BigDecimal contractProductNumber = new BigDecimal(contractProduct.getCnumber());
            productTotalAmount = contractProductNumber.multiply(contractProduct.getPrice());
        }
        //设置购销合同货物总金额
        contractProduct.setAmount(productTotalAmount);
        //保存货物对象
        contractProductDao.insertSelective(contractProduct);

        //查询合同对象
        Contract contract = contractDao.selectByPrimaryKey(contractProduct.getContractId());
        //修改合同货物总金额
        contract.setTotalAmount(contract.getTotalAmount().add(productTotalAmount));
        //修改合同货物数量
        contract.setProNum(contract.getProNum() + 1);
        //保存合同对象
        contractDao.updateByPrimaryKeySelective(contract);
    }

    @Override
    public void update(ContractProduct contractProduct) {
        //计算当前货物的总金额
        BigDecimal newProductTotal = new BigDecimal(0);
        if (contractProduct.getCnumber() != null && contractProduct.getPrice() != null) {
            BigDecimal contractProductNumber = new BigDecimal(contractProduct.getCnumber());
            newProductTotal = contractProductNumber.multiply(contractProduct.getPrice());
        }
        //查询购销合同中之前货物的总金额
        ContractProduct oldProduct = contractProductDao.selectByPrimaryKey(contractProduct.getId());
        BigDecimal oldProductTotal = oldProduct.getAmount();
        //保存货物总金额
        contractProduct.setAmount(newProductTotal);
        contractProductDao.updateByPrimaryKeySelective(contractProduct);

        //查询购销合同对象
        Contract contract = contractDao.selectByPrimaryKey(contractProduct.getContractId());
        //设置新的货物总金额
        contract.setTotalAmount(contract.getTotalAmount().subtract(oldProductTotal).add(newProductTotal));
        //更新购销合同对象
        contractDao.updateByPrimaryKeySelective(contract);
    }

    @Override
    public void delete(String contractProductId) {
        //查询该货物对象
        ContractProduct contractProduct = contractProductDao.selectByPrimaryKey(contractProductId);
        //查询该货物下的附件
        ExtCproductExample extCproductExample = new ExtCproductExample();
        extCproductExample.createCriteria().andContractProductIdEqualTo(contractProductId);
        List<ExtCproduct> extCproducts = extCproductDao.selectByExample(extCproductExample);
        //查询购销合同对象
        Contract contract = contractDao.selectByPrimaryKey(contractProduct.getContractId());
        //计算货物和附件的总金额
        BigDecimal total = contractProduct.getAmount();
        for (ExtCproduct extCproduct : extCproducts) {
            total = total.add(extCproduct.getAmount());
            extCproductDao.deleteByPrimaryKey(extCproduct.getId());
        }
        //删除货物
        contractProductDao.deleteByPrimaryKey(contractProduct.getId());
        //修改购销合同总金额
        contract.setTotalAmount(contract.getTotalAmount().subtract(total));
        //修改购销合同货物和附件数量
        if (contract.getProNum() != 0) {
            contract.setProNum(contract.getProNum() - 1);
        }
        if (contract.getExtNum() != 0) {
            contract.setExtNum(contract.getExtNum() - extCproducts.size());
        }
        //更新购销合同信息
        contractDao.updateByPrimaryKeySelective(contract);
    }

}
