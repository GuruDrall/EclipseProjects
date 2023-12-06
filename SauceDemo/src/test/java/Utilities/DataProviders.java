package Utilities;

import org.testng.annotations.DataProvider;

public class DataProviders {
	String SheetWithCorrectCreds = "CorrectCreds";
	String SheetWithIncorrectCreds = "IncorrectCreds";

	@DataProvider(name = "correct_creds_data")
	public Object[][] Credentials() {
		ExcelLibrary excel =new ExcelLibrary(SheetWithCorrectCreds);
		int actRow = excel.getRowCount();
		int actColumn = excel.getColumnCount();
		Object[][] creds = new Object[actRow-1][actColumn];
		for (int i = 1; i < actRow; i++) {
			for (int j = 0; j < actColumn; j++) {
				creds[i - 1][j] = excel.getCellValue(i, j);
//				System.out.println(creds[i - 1][j]);
			}
		}
		return creds;
	}
	
	@DataProvider(name = "incorrect_creds_data")
	public Object[][] Credentials2() {
		ExcelLibrary excel =new ExcelLibrary(SheetWithIncorrectCreds);
		int actRow = excel.getRowCount();
		int actColumn = excel.getColumnCount();
		Object[][] creds = new Object[actRow-1][actColumn];
		for (int i = 1; i < actRow; i++) {
			for (int j = 0; j < actColumn; j++) {
				creds[i - 1][j] = excel.getCellValue(i, j);
				System.out.println(creds[i - 1][j]);
			}
		}
		return creds;
	}

}
