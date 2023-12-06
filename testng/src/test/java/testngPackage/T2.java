package testngPackage;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class T2 {

	@Test
	@Parameters({ "c", "d"})
	void sumT2cd(int c, int d) {
		System.out.println("Sum of c & d is : " + (c + d));
	}

}
