package testNG_module1;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Before_Method {
	
	
	// @BeforeMethod annotation ( it implements pre-condition on method)
		@BeforeMethod
		void pre_condition2()
		{
			System.out.println("Pre condition2 of BeforeMethod");	
		}
		@BeforeMethod
		void pre_condition()
		{
			System.out.println("Pre condition of BeforeMethod");	
		}
		
	 // @test used for writing test cases
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
	
	// @After Method ( it implements post condition on method)
	@AfterMethod
	void post_condition()
	{
		System.out.println("Post condition of AfterMethod");
	}
	
	
	
	
	

}
