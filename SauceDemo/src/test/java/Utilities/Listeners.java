package Utilities;

import java.io.File;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class Listeners extends Testng_Report implements ITestListener {
	
	
	@Override
	public void onStart(ITestContext context) {
		
		setupReport();
		setEnvirementSetup();
		System.out.println("Test case execution started");
			
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(result.getName() + " Method Started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test = report.createTest(result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel("TestCase Pass", ExtentColor.GREEN));

		if (result.getStatus() == 1) {
			System.out.println("====== SUCCESS ======");
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		screenshot();
		test = report.createTest(result.getName());
		String ssPath = "C:\\Users\\gsdra\\eclipse-workspace\\SauceDemo\\Screenshots\\ss1";
		File ss1 = new File(ssPath);
		if(ss1.exists()) {
			test.fail("Captured Screenshot"+test.addScreenCaptureFromPath(ssPath));
		}
		test.log(Status.FAIL, MarkupHelper.createLabel("TestCase Fail", ExtentColor.RED));

		if (result.getStatus() == 2) {
			System.out.println("====== Failure ======");
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test = report.createTest(result.getName());
		test.log(Status.WARNING, MarkupHelper.createLabel("TestCase Fail Due to Timeout", ExtentColor.RED));

		System.out.println("TestCase Skipped : " + result.getName() + " " + result.getStatus());
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		test = report.createTest(result.getName());
		test.log(Status.WARNING, MarkupHelper.createLabel("TestCase Fail Due to Timeout", ExtentColor.RED));

		System.out.println("====== TestCase Failed due to Timeout : " + result.getName() + " " + result.getStatus() + " ======");
	}

	@Override
	public void onFinish(ITestContext context) {
		if (context.getFailedTests().size() == 0) {
			System.out.println("=============== All Test Cases Executed Successfully ===============");
		} else {
			System.out.println("====== Total Test Case Failed : " + context.getFailedTests().size() + " ======");
		}
		report.flush();
	}

}
