package com.zhiyou100.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;

/**
 * @author Liyajun
 * @date 2019年9月18日
 * @desc 导出 : 从程序中导出到本地
 * 
 */
public class TestPOI {
	@Test
	public void export() throws IOException {
	// 1. 创建工作表
	HSSFWorkbook wb = new HSSFWorkbook();
	// 2. 创建sheet
	HSSFSheet sheet1 = wb.createSheet();
	//3. 在sheet中创建行
	// 参数 row() 指创建第几行  从零开始
	HSSFRow row0 = sheet1.createRow(0);
	//4. 在行中创建列
	// 参数column 指创建第几列  从零开始
	HSSFCell r0c0 = row0.createCell(0);
	//5. 单元格内写内容
	r0c0.setCellValue("门诊编号");
	//6. 导出
	OutputStream os = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\1.xls");
	wb.write(os);
	os.close();
}
	
	/**
	 * 导入 ; 从本地导入到项目(程序)
	 * @throws IOException 
	 * @throws Exception 
	 */
	@Test
	public void importExcel() throws IOException {
		//1. 将本地文件已输入流的形式读入程序
		InputStream in = new FileInputStream("C:\\\\Users\\\\Administrator\\\\Desktop\\\\1.xls");
		
		//2. 通过流创建工作表
		HSSFWorkbook wb = new HSSFWorkbook(in);
		// 3. 获得sheet
		HSSFSheet sheet0 = wb.getSheetAt(0);
		// 4. 获得行
		HSSFRow row1 = sheet0.getRow(1);
		// 5.获得列
		HSSFCell r1c1 = row1.getCell(1);
		// 6. 获得值
		String value = r1c1.getStringCellValue();
		System.out.println("导入Excel,读出数据 : " + value);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}