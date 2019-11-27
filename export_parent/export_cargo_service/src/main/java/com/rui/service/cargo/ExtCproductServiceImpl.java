package com.rui.service.cargo;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rui.dao.cargo.ContractDao;
import com.rui.dao.cargo.ContractProductDao;
import com.rui.dao.cargo.ExtCproductDao;
import com.rui.domain.cargo.Contract;
import com.rui.domain.cargo.ExtCproduct;
import com.rui.domain.cargo.ExtCproductExample;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

/**
 * @description: 购销合同 -> 附件 服务提供者
 * @author: caihongrui
 * @createtime: 2019-11-27 14:45
 **/
@Service
public class ExtCproductServiceImpl implements ExtCproductService {

    @Autowired
    private ContractDao contractDao;

    @Autowired
    private ContractProductDao contractProductDao;

    @Autowired
    private ExtCproductDao extCproductDao;


    @Override
    public PageInfo findAll(ExtCproductExample extCproductExample, int page, int size) {
        PageHelper.startPage(page, size);
        List<ExtCproduct> extCproducts = extCproductDao.selectByExample(extCproductExample);
        return new PageInfo(extCproducts);
    }

    @Override
    public ExtCproduct findExtCproductById(String id) {
        return extCproductDao.selectByPrimaryKey(id);
    }

    @Override
    public void save(ExtCproduct extCproduct) {
        //设置id
        extCproduct.setId(UUID.randomUUID().toString());
        //计算附件总金额
        BigDecimal extCproductTotalAmount = new BigDecimal(0);
        if (extCproduct.getCnumber() != null && extCproduct.getPrice() != null) {
            BigDecimal extCproductNumber = new BigDecimal(extCproduct.getCnumber());
            extCproductTotalAmount = extCproductNumber.multiply(extCproduct.getPrice());
        }
        //设置附件总金额
        extCproduct.setAmount(extCproductTotalAmount);
        //保存附件对象
        extCproductDao.insertSelective(extCproduct);
        //查询购销合同对象
        Contract contract = contractDao.selectByPrimaryKey(extCproduct.getContractId());
        //修改购销合同总金额
        contract.setTotalAmount(contract.getTotalAmount().add(extCproductTotalAmount));
        //修改购销合同附件数量
        contract.setExtNum(contract.getExtNum() + 1);
        //修改购销合同对象
        contractDao.updateByPrimaryKeySelective(contract);
    }

    @Override
    public void update(ExtCproduct extCproduct) {
        //计算修改之后的附件总金额
        BigDecimal extCproductTotalAmount = new BigDecimal(0);
        if (extCproduct.getCnumber() != null && extCproduct.getPrice() != null) {
            BigDecimal extCproductNumber = new BigDecimal(extCproduct.getCnumber());
            extCproductTotalAmount = extCproductNumber.multiply(extCproduct.getPrice());
        }
        //查询修改之前附件总金额
        ExtCproduct oldExtCproduct = extCproductDao.selectByPrimaryKey(extCproduct.getId());
        BigDecimal oldAmount = oldExtCproduct.getAmount();
        //设置附件总金额
        extCproduct.setAmount(extCproductTotalAmount);
        //保存附件对象
        extCproductDao.updateByPrimaryKeySelective(extCproduct);
        //查询购销合同对象
        Contract contract = contractDao.selectByPrimaryKey(extCproduct.getContractId());
        //修改购销合同总金额
        contract.setTotalAmount(contract.getTotalAmount().subtract(oldAmount).add(extCproductTotalAmount));
        //修改购销合同
        contractDao.updateByPrimaryKeySelective(contract);
    }

    @Override
    public void delete(String id) {
        //查询附件对象
        ExtCproduct extCproduct = extCproductDao.selectByPrimaryKey(id);
        //获取附件总金额
        BigDecimal amount = extCproduct.getAmount();
        //删除附件
        extCproductDao.deleteByPrimaryKey(id);
        //查询购销合同
        Contract contract = contractDao.selectByPrimaryKey(extCproduct.getContractId());
        //设置购销合同总金额
        contract.setTotalAmount(contract.getTotalAmount().subtract(amount));
        //设置购销合同附件数量
        contract.setExtNum(contract.getExtNum() - 1);
        //修改购销合同信息
        contractDao.updateByPrimaryKeySelective(contract);
    }
}
