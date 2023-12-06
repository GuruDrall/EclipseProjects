package testngPackage;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class T1 {
	@Parameters({ "a", "b" })
	@Test
	void sumT1ab(int a, int b) {
		System.out.println("Sum of a & b is : " + (a + b));
	}

	@Test
	@Parameters({ "c", "d" })
	void sumT1cd(int c, int d) {
		System.out.println("Sum of c & d is : " + (c + d));
	}
	

}
