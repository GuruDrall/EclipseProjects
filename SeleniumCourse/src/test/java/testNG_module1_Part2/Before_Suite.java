package testNG_module1_Part2;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Before_Suite {

	// Before Suite annotation ( two or more than two Packages run simultaneously
	@BeforeSuite
	void pre_condition() {
		System.out.println("Pre condition of BeforeSuite");
	}

	// @test used for writing test cases
	@Test
	// creating method(test case) 5
	void TestCase5() {
		System.out.println("Test Case 5");
	}

	// creating method(test case) 6
	@Test
	void TestCase6() {
		System.out.println("Test Case 6");
	}

	// @After Suite ( it implements package post condition)
	@AfterSuite
	void post_condition() {
		System.out.println("Post condition of AfterSuite");
	}
}
