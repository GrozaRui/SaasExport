package com.rui.service.export;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rui.dao.cargo.ContractDao;
import com.rui.dao.cargo.ContractProductDao;
import com.rui.dao.cargo.ExtCproductDao;
import com.rui.dao.export.ExportDao;
import com.rui.dao.export.ExportProductDao;
import com.rui.dao.export.ExtEproductDao;
import com.rui.domain.cargo.*;
import com.rui.domain.export.Export;
import com.rui.domain.export.ExportExample;
import com.rui.domain.export.ExportProduct;
import com.rui.domain.export.ExtEproduct;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

/**
 * @description: 远程调用接口实现类 : 报运单功能
 * @author: caihongrui
 * @createtime: 2019-11-29 10:48
 **/
@Service
public class ExportServiceImpl implements ExportService {

    @Autowired
    private ExportDao exportDao;

    @Autowired
    private ExportProductDao exportProductDao;

    @Autowired
    private ExtEproductDao extEproductDao;

    @Autowired
    private ContractDao contractDao;

    @Autowired
    private ContractProductDao contractProductDao;

    @Autowired
    private ExtCproductDao extcproductDao;


    /**
     * 保存报运单
     * 将选择的购销合同信息保存到报运单信息中
     * 修改购销合同的状态码
     * @param export
     */
    @Override
    public void save(Export export) {
        //设置基本属性
        export.setId(UUID.randomUUID().toString());
        export.setCreateTime(new Date());
        export.setState(0L);
        //获取勾选的购销合同id字符串数组
        String[] contractIds = export.getContractIds().split(",");
        //查询所有的购销合同并修改状态
        String contractNo = "";
        for (String contractId : contractIds) {
            Contract contract = contractDao.selectByPrimaryKey(contractId);
            contract.setState(2);
            contractDao.updateByPrimaryKeySelective(contract);
            contractNo += contract.getContractNo() + " ";
        }
        export.setCustomerContract(contractNo);
        //根据购销合同id集合以in的形式查询合同下的所有货物
        ContractProductExample contractProductExample = new ContractProductExample();
        contractProductExample.createCriteria().andContractIdIn(Arrays.asList(contractIds));
        List<ContractProduct> contractProducts = contractProductDao.selectByExample(contractProductExample);
        //根据查询的货物构造报运单商品 货物id = 1 -- 商品id = 1
        Map<String, String> map = new HashMap(); // 记录货物id 和商品id 之间的关系
        for (ContractProduct contractProduct : contractProducts) {
            ExportProduct exportProduct = new ExportProduct();
            BeanUtils.copyProperties(contractProduct, exportProduct);
            exportProduct.setId(UUID.randomUUID().toString());
            map.put(contractProduct.getId(), exportProduct.getId());
            exportProduct.setExportId(export.getId());
            //保存报运商品对象
            exportProductDao.insertSelective(exportProduct);
        }
        //根据购销合同id数组以in形式查询合同下的所有附件对象
        ExtCproductExample extcproductexample = new ExtCproductExample();
        extcproductexample.createCriteria().andContractIdIn(Arrays.asList(contractIds));
        List<ExtCproduct> extCproducts = extcproductDao.selectByExample(extcproductexample);
        //根据购销合同附件构造报运单附件数据
        for (ExtCproduct extCproduct : extCproducts) {
            ExtEproduct extEproduct = new ExtEproduct();
            BeanUtils.copyProperties(extCproduct, extEproduct);
            extEproduct.setId(UUID.randomUUID().toString());
            extEproduct.setExportProductId(map.get(extCproduct.getContractProductId()));
            extEproduct.setExportId(export.getId());
            extEproductDao.insertSelective(extEproduct);
        }
        export.setProNum(contractProducts.size());
        export.setExtNum(extCproducts.size());
        exportDao.insertSelective(export);
    }

    @Override
    public void update(Export export) {
        exportDao.updateByPrimaryKeySelective(export);
        if(export.getExportProducts() != null) {
            for (ExportProduct exportProduct : export.getExportProducts()) {
                exportProductDao.updateByPrimaryKeySelective(exportProduct);
            }
        }
    }

    @Override
    public void delete(String id) {
        exportDao.deleteByPrimaryKey(id);
    }

    @Override
    public PageInfo findAll(ExportExample example, int page, int size) {
        PageHelper.startPage( page , size);
        List<Export> exports = exportDao.selectByExample(example);
        return new PageInfo(exports);
    }

    @Override
    public Export findById(String id) {
        return exportDao.selectByPrimaryKey(id);
    }
}
