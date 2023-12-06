package testngPackage;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderClass {
	@DataProvider
	public Object[][] countryCode() {
//		String[][] obj = {{"New Delhi","India"},{"Nodia", "India"},{"Delhi","India",}};
		Object[][] obj = new Object[2][2];
		obj[0][0] = "India";
		obj[0][1] = 91;
		obj[1][0] = "USA";
		obj[1][1] = 1;
		
		return obj;
	}

	@Test(dataProvider = "countryCode")
	void country_code(Object country, Object code) {
		System.out.print("Country & country code  : ");
		System.out.println(country + ", " + code);
	}
}