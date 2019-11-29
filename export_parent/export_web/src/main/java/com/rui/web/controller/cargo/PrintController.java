package com.rui.web.controller.cargo;

import com.alibaba.dubbo.config.annotation.Reference;
import com.rui.domain.cargo.ContractProductVo;
import com.rui.service.cargo.ContractProductService;
import com.rui.service.cargo.ContractService;
import com.rui.util.DownloadUtil;
import com.rui.web.controller.BaseController;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping(value = "/cargo/contract")
public class PrintController extends BaseController {

	@Reference
	private ContractProductService contractProductService;

	@Reference
	private ContractService contractService;

	@RequestMapping(value="/print")
	public String print() {
		return "cargo/print/contract-print";
	}

	@RequestMapping(value = "/printExcel", name = "百万数据出货表打印")
	public void printExcel(String inputDate) throws IOException {
		List<ContractProductVo> contractProductVoList = contractProductService.findVoByShipTime(inputDate, companyId);
		System.err.println(contractProductVoList);

		//创建工作簿
		SXSSFWorkbook workbook = new SXSSFWorkbook();
		//创建表对象
		Sheet sheet = workbook.createSheet();
		//索引 创建行对象
		int index =0;
		Row row = sheet.createRow(index++);
		//合并单元格
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 1, 8));
		//从行对象获取大标题单元格对象并赋值
		Cell cell = row.createCell(1);
		cell.setCellValue(inputDate.replace("-","年")+"月份出货表");
		cell.setCellStyle(bigTitle(workbook));
		//创建第二行的行对象
		row = sheet.createRow(index++);
		//然后根据string数组循环赋值和样式
		//客户	订单号	货号	数量	工厂	工厂交期	船期	贸易条款
		String[] headerNames = {"" ,"客户","订单号","货号","数量","工厂","工厂交期","船期","贸易条款"};
		//遍历String数组为小标题单元格赋值和样式
		for (int i = 1; i < headerNames.length;i++) {
			cell = row.createCell(i);
			cell.setCellValue(headerNames[i]);
			cell.setCellStyle(title(workbook));
		}

		//遍历contractProductVoList集合  循环添加数据
		for (ContractProductVo contractProductVo : contractProductVoList) {
			for (int i = 0; i < 1; i++) {  // 160 * 5000 = 80,0000
				row = sheet.createRow(index++);
				// 客户
				cell = row.createCell(1);
				cell.setCellValue(contractProductVo.getCustomName());
				// 订单号
				cell = row.createCell(2);
				cell.setCellValue(contractProductVo.getContractNo());
				// 货号
				cell  = row.createCell(3);
				cell.setCellValue(contractProductVo.getProductNo());
				// 数量
				cell = row.createCell(4);
				cell.setCellValue(contractProductVo.getCnumber());
				// 工厂
				cell = row.createCell(5);
				cell.setCellValue(contractProductVo.getFactoryName());
				// 工厂交期
				cell = row.createCell(6);
				cell.setCellValue(contractProductVo.getDeliveryPeriod());
				// 船期
				cell = row.createCell(7);
				cell.setCellValue(contractProductVo.getShipTime());
				// 贸易条款
				cell = row.createCell(8);
				cell.setCellValue(contractProductVo.getTradeTerms());
			}
		}

		//实例化下载工具类 content-disposition : attachment;filename=xx文件名称.后缀
		DownloadUtil downloadUtil = new DownloadUtil();
		//创建输出流
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		//将工作簿转换为输出流
		workbook.write(byteArrayOutputStream);
		//将工作簿流作为响应下载输出
		downloadUtil.download(byteArrayOutputStream,response,"出货表.xlsx");
	}
	//大标题的样式
	public CellStyle bigTitle(Workbook wb){
		CellStyle style = wb.createCellStyle();
		Font font = wb.createFont();
		font.setFontName("宋体");
		font.setFontHeightInPoints((short)16);
		font.setBold(true);//字体加粗
		style.setFont(font);
		style.setAlignment(HorizontalAlignment.CENTER);				//横向居中
		style.setVerticalAlignment(VerticalAlignment.CENTER);		//纵向居中
		return style;
	}

	//小标题的样式
	public CellStyle title(Workbook wb){
		CellStyle style = wb.createCellStyle();
		Font font = wb.createFont();
		font.setFontName("黑体");
		font.setFontHeightInPoints((short)12);
		style.setFont(font);
		style.setAlignment(HorizontalAlignment.CENTER);				//横向居中
		style.setVerticalAlignment(VerticalAlignment.CENTER);		//纵向居中
		style.setBorderTop(BorderStyle.THIN);						//上细线
		style.setBorderBottom(BorderStyle.THIN);					//下细线
		style.setBorderLeft(BorderStyle.THIN);						//左细线
		style.setBorderRight(BorderStyle.THIN);						//右细线
		return style;
	}

	//文字样式
	public CellStyle text(Workbook wb){
		CellStyle style = wb.createCellStyle();
		Font font = wb.createFont();
		font.setFontName("Times New Roman");
		font.setFontHeightInPoints((short)10);

		style.setFont(font);

		style.setAlignment(HorizontalAlignment.LEFT);				//横向居左
		style.setVerticalAlignment(VerticalAlignment.CENTER);		//纵向居中
		style.setBorderTop(BorderStyle.THIN);						//上细线
		style.setBorderBottom(BorderStyle.THIN);					//下细线
		style.setBorderLeft(BorderStyle.THIN);						//左细线
		style.setBorderRight(BorderStyle.THIN);						//右细线

		return style;
	}
}