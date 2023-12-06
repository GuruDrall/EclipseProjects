package testngPackage;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Xcel_Class1 {

	@Test(dataProvider = "Databody1")

	public void m1(String s, String s1) {
		System.out.println("this entered value " + s + " " + s1);

	}

	@DataProvider
	public String[][] Databody1() throws IOException {
		String filename = "C:\\Users\\gsdra\\eclipse-workspace\\testng\\resources\\Book1.xlsx";
		String sheetname = "Username";
		String[][] arr = getExcelData(filename, sheetname);
		return arr;
	}

	public String[][] getExcelData(String filename1, String sheetname1) throws IOException {
		int row;
		int column;
		FileInputStream fis = new FileInputStream(filename1);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet(sheetname1);
		row = sheet.getLastRowNum();
		System.out.println(row);
		column = sheet.getRow(0).getLastCellNum();
		System.out.println(column);
		String[][] data = new String[row][column];

		for (int i = 1; i <= row; i++) {
			for (int j = 0; j < column; j++) {
				System.out.println("data["+(i-1)+"]["+j+"]=="+sheet.getRow(i).getCell(j).toString() );
				data[i-1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return data;
	}
}
