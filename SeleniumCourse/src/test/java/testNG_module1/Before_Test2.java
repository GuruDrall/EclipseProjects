package testNG_module1;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Before_Test2 {

	
	@BeforeClass
	void pre_condition()
	{
		System.out.println("Pre condition BeforeClass");
	}  
	
	@Test
	// creating method(test case) 1
	void TestCase1()
	{
		System.out.println("Test Case 1");
	}
	
	// creating method(test case) 2
	@Test
	void TestCase2()
	{
		System.out.println("Test Case 2");
	}
	
	@AfterClass
	void post_condition()
	{
		System.out.println("Post condition of AfterClass");	
	}
}
