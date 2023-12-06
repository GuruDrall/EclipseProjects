package testNG_module1;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Before_Test {

	// Before Test annotation ( two or more than two classes run simultaneously
	// within a package)
	@BeforeTest
	void pre_condition() {
		System.out.println("Pre condition of BeforeTest");
	}

	// @test used for writing test cases
	@Test
// creating method(test case) 1
	void TestCase3() {
		System.out.println("Test Case 3");
	}

// creating method(test case) 2
	@Test
	void TestCase4() {
		System.out.println("Test Case 4");
	}

// @After Test ( it implements class post condition/s)
	@AfterTest
	void post_condition() {
		System.out.println("Post condition of AfterTest");
	}
}
