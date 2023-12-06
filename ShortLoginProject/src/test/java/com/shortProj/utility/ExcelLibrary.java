package com.shortProj.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.main.base.BaseClass1;

public class ExcelLibrary extends BaseClass1 {
	public XSSFWorkbook wb;
	public XSSFSheet ws;

	
	public ExcelLibrary() {
//		String[][] eData = null;
//		String fileName = prop.getProperty("excelFilePath");
//		String sheetName = prop.getProperty("excelSheet");
		
		String fileName = "C:\\Users\\gsdra\\eclipse-workspace\\ShortLoginProject\\src\\test\\resources\\TestData\\TestData.xlsx";
		String sheetName = "credentials";
		
			FileInputStream fis = null;
			try {
				fis = new FileInputStream(fileName);
				wb = new XSSFWorkbook(fis);
				ws = wb.getSheet(sheetName);
				fis.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
	}	

	public int getRowCount() {
		int row = ws.getLastRowNum();
		return row;
	}
	public int getColumnCount() {
		int column = ws.getRow(0).getLastCellNum();
		return column;
	}
	
	public String getCellValue(int row, int col) {
		String cellValue= ws.getRow(row).getCell(col).getStringCellValue();
		return cellValue;
	}
	public Object[][] getExcelData() {
		int row = getRowCount();
		int col = getColumnCount();
		Object excelData[][] = new Object[row][col];
		for (int i = 1; i <= row; i++) {
			for (int j = 0; j < col; j++) {
				excelData[i - 1][j] = ws.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return excelData;
	}
	
}
