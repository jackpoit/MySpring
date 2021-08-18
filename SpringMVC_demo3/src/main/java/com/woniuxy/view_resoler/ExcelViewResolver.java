package com.woniuxy.view_resoler;

import com.woniuxy.domain.User;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @Author: jackpoit
 * Excel格式的视图解析模板
 */
@SuppressWarnings("all") //压制警告
@Component("excelView") //将视图解析模板交给Spring容器
public class ExcelViewResolver extends AbstractXlsView {

	@Override
	protected void buildExcelDocument(Map<String, Object> map, Workbook workbook, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {

		//1.完成excel下载(指定下载默认的响应头)
		httpServletResponse.setHeader(HttpHeaders.CONTENT_DISPOSITION,"attachment;filename=user.xlsx");
		//2.创建excel工作簿
		Sheet sheet = workbook.createSheet("user数据");
		//3.填写表头
		Row header = sheet.createRow(0);
		Cell c0 = header.createCell(0);
		c0.setCellValue("编号");
		Cell c1 = header.createCell(1);
		c1.setCellValue("昵称");
		Cell c2 = header.createCell(2);
		c2.setCellValue("真实姓名");
		//4.从model模型中取出ModelAndView中的data
		@SuppressWarnings("unchecked") //压制警告
		List<User> list = (List<User>) map.get("data");
		for (int i=0;i<list.size();i++) {
			Row row = sheet.createRow(i + 1);
			User user = list.get(i);
			Cell cell0 = row.createCell(0);
			cell0.setCellValue(user.getId());
			Cell cell1 = row.createCell(1);
			cell1.setCellValue(user.getUname());
			Cell cell2 = row.createCell(2);
			cell2.setCellValue(user.getRealname());
		}
		
	}
}
