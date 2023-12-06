/**
 * 
 */
package com.shortProj.dataProviders;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.main.base.BaseClass1;
import com.shortProj.utility.ExcelLibrary;

/**
 * 
 */
public class dataProviderClass extends BaseClass1 {
	public ExcelLibrary excelLib = new ExcelLibrary();

	@DataProvider(name = "excelData")
	public Object[][] getExcelData() {
		int actRow = excelLib.getRowCount();
		int actColumn = excelLib.getColumnCount();
		Object[][] excelData = new Object[actRow][actColumn];
//		Object[][] excelData = excelLib.getExcelData();
		for (int i = 1; i <= actRow; i++) {
			for (int j = 0; j < actColumn; j++) {
				excelData[i - 1][j] = excelLib.getCellValue(i, j);
			}
		}
		return excelData;

	}

}
