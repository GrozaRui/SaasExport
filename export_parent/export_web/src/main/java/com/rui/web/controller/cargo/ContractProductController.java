package com.rui.web.controller.cargo;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.rui.domain.cargo.ContractProduct;
import com.rui.domain.cargo.ContractProductExample;
import com.rui.domain.cargo.FactoryExample;
import com.rui.service.cargo.ContractProductService;
import com.rui.service.cargo.FactoryService;
import com.rui.util.FileUploadUtil;
import com.rui.web.controller.BaseController;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.Multipart;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: 购销合同->货物 控制器
 * @author: caihongrui
 * @createtime: 2019-11-26 15:22
 **/
@Controller
@RequestMapping("/cargo/contractProduct")
public class ContractProductController extends BaseController {

    @Reference
    private ContractProductService contractProductService;

    @Reference
    private FactoryService factoryService;

    @RequestMapping(value = "/list", name = "分页查询货物列表")
    public String productList(String contractId, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5") int size) {
        ContractProductExample contractProductExample = new ContractProductExample();
        contractProductExample.createCriteria().andContractIdEqualTo(contractId);
        //查询出货物的同时嵌套查询出货物下的附件的信息
        PageInfo pageInfo = contractProductService.findAll(contractProductExample, page, size);
        request.setAttribute("page", pageInfo);

        //查询所有的生产厂家
        FactoryExample factoryExample = new FactoryExample();
        FactoryExample.Criteria criteria = factoryExample.createCriteria();
        criteria.andCtypeEqualTo("货物");
        List factoryList = factoryService.findAll(factoryExample);
        request.setAttribute("factoryList",factoryList);
        //将购销合同id存入request
        request.setAttribute("contractId",contractId);
        return "/cargo/product/product-list";
    }


    @RequestMapping(value = "/toUpdate",name = "跳转到修改购销合同信息页面")
    public String toUpdate(String id) {
        //查询该产品的信息
        ContractProduct contractProduct = contractProductService.findProductById(id);
        request.setAttribute("contractProduct",contractProduct);
        //查询所有厂家的信息列表
        FactoryExample factoryExample = new FactoryExample();
        factoryExample.createCriteria().andCtypeEqualTo("货物");
        List factoryList = factoryService.findAll(factoryExample);
        request.setAttribute("factoryList", factoryList);
        return "/cargo/product/product-update";
    }

    @RequestMapping(value = "/edit", name = "保存货物信息")
    public String edit(ContractProduct contractProduct, MultipartFile productPhoto) throws Exception {
        //保存公司信息
        contractProduct.setCompanyId(companyId);
        contractProduct.setCompanyName(companyName);
        if (StringUtils.isEmpty(contractProduct.getId())) {
            if(productPhoto != null && !productPhoto.isEmpty()) {
                String url = new FileUploadUtil().upload(productPhoto);
                contractProduct.setProductImage(url);
            }
            contractProductService.save(contractProduct);
        } else {
            contractProductService.update(contractProduct);
        }
        return "redirect:/cargo/contractProduct/list.do?contractId=" + contractProduct.getContractId();
    }

    @RequestMapping(value = "/delete", name = "删除货物信息")
    public String delete(String id,String contractId) {
        contractProductService.delete(id);
        return "redirect:/cargo/contractProduct/list.do?contractId=" + contractId;
    }

    @RequestMapping(value="/toImport",name = "跳转到导入页面")
    public String toImport(String contractId) {
        request.setAttribute("contractId",contractId);
        return "cargo/product/product-import";
    }

    @RequestMapping(value = "/import", name = "批量导入货物")
    public String importExcel(String contractId, MultipartFile file) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
        XSSFSheet sheet = workbook.getSheetAt(0);

        //遍历表 依次获取每个单元格数据
        List<ContractProduct> list = new ArrayList<>();
        for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
            Row row = sheet.getRow(i);
            Object[] objects = new Object[row.getLastCellNum()];
            for (int j = 1; j < row.getLastCellNum(); j++) {
                Cell cell = row.getCell(j);
                if (cell != null) {
                    objects[j] = getCellValue(cell);
                }
            }
            ContractProduct contractProduct = new ContractProduct(objects, companyId, companyName);
            contractProduct.setContractId(contractId);
            list.add(contractProduct);
        }
        contractProductService.saveAll(list);
        return "redirect:/cargo/contractProduct/list.do?contractId="+contractId;
    }

    private static Object getCellValue(Cell cell) {
        Object object = null;
        CellType cellType = cell.getCellType();
        switch (cellType) {
            case STRING:
                object = cell.getStringCellValue();
                break;
                //excel默认将日期也认为是数字
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    object = cell.getDateCellValue();
                } else {
                    object = cell.getNumericCellValue();
                }
                break;
            case BOOLEAN:
                object = cell.getBooleanCellValue();
                break;
            default:
                break;
        }
        return object;
    }

}
