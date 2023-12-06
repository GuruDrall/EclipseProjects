package testngPackage;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersDemo {

	@DataProvider
	Object[] address() {
		Object obj[] = new Object[3];
		obj[0] = "New Delhi";
		obj[1] = "India";
		obj[2] = 110043;

		return obj;
	}

	@Test(priority = 4)
	void sum(@Optional("10") int a, @Optional("20") int b) {
		System.out.println("Sum of a & b is : " + (a + b));
	}

	@Test(priority = 1)
	@Parameters({ "first", "last" })
	void printName(String first, String last) {
		System.out.println("Name is " + first + " " + last);
	}

	@Test(priority = 3)
	@Parameters({ "state", "country"})
	void location(String state, String country) {
		System.out.print("Addr is : ");
		System.out.println(state + ", " + country );
	}

	@Test(priority = 2)
	@Parameters({ "age" })
	void age(int age) {
		System.out.println("Age is : " + age);
	}

}
