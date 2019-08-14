package com.miaomiao.it.learning.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FinalResultExecel {
	private static final Integer SUMMARY_ID = 999999999; //汇总信息ID
	public static void managerResult(String srcFilePath, String destFilePath, Map<Integer, String> map,int sheetNum) {

		try {
			copyFile(srcFilePath, destFilePath);// 复制源文件到新文件
			File excelFile = new File(destFilePath); // 创建文件对象
			FileInputStream is = new FileInputStream(excelFile);// 文件流
			Workbook workbook = WorkbookFactory.create(is);// 这种方式 Excel 2003/2007/2010 都是可以处理的
			Sheet sheet = workbook.getSheetAt(sheetNum);
			int rowCount = sheet.getPhysicalNumberOfRows();// 获取总行数
			Row row0 = sheet.getRow(0);// 得到0行
			int cellCount = row0.getPhysicalNumberOfCells();// 得到0行的列数
			//生成一个样式
			CellStyle cellStyle = workbook.createCellStyle();
			Font font = workbook.createFont();
			font.setColor(IndexedColors.RED.getIndex());
			cellStyle.setFont(font);
			for (int k = 0; k < rowCount; k++) {
				Row row = sheet.getRow(k);
				Cell newCell = row.createCell(cellCount);
				newCell.setCellValue(map.get(k));
				//设置单元格样式
				newCell.setCellStyle(cellStyle);
				
			}
			String summaryMessages  = map.get(SUMMARY_ID);
			if(StringUtils.isNotBlank(summaryMessages )){
				Row lastRow = sheet.createRow(rowCount);
				Cell lastCell = lastRow.createCell(cellCount);
				lastCell.setCellValue(summaryMessages );
				lastCell.setCellStyle(cellStyle);
			}
			sheet.autoSizeColumn((short)cellCount);
			FileOutputStream fo = new FileOutputStream(destFilePath);
			workbook.write(fo);
//			System.out.println("------------------------->"+"Operation Success!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		}
	}
	public static void copyFile(String srcFile,String destFile){
		File src = new File(srcFile);
		File dest = new File(destFile);
		try {
			FileUtils.copyFile(src,dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
//	public static void main(String[] args) {
//		String srcFilePath = "d:\\test.xlsx";
//		String destFilePath = "d:\\test_result_new.xlsx";
//		int sheetNum = 0;
//		Map<Integer,String> map = new HashMap<Integer,String>();
//		map.put(0, "errorDesc");
//		map.put(1, "xxxxxx");
//		map.put(2, "xxxxxxxxxxxxxxxxxxxx");
//		map.put(5, "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
//		map.put(999999999, "Sumarry Message ID is 9个9");
//		managerResult(srcFilePath,destFilePath,map,sheetNum);
//		
//	}
}