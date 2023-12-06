package Utilities;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import TestCases.BaseClass;

public class ExcelLibrary extends BaseClass{
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	String excelFile = "C:\\Users\\gsdra\\eclipse-workspace\\SauceDemo\\src\\test\\resources\\Credentials.xlsx";	
	
	public ExcelLibrary(String SheetName) {
		try {
			fis = new FileInputStream(excelFile);
			wb = new XSSFWorkbook(fis);
			sheet = wb.getSheet(SheetName);
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public Object[][] getCreds() {
		return null;
	}

	public int getRowCount() {
		int totalRow = sheet.getLastRowNum();
		return totalRow;
	}

	public int getColumnCount() {
		int totalColumn = sheet.getRow(0).getLastCellNum();
		return totalColumn;
	}

	public Object getCellValue(int i, int j) {
		cell = sheet.getRow(i).getCell(j);
		return cell.getStringCellValue();
	}

}
