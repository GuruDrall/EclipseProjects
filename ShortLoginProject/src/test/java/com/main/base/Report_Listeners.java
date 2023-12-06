package com.main.base;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Report_Listeners extends Test_Cases implements ITestListener {
	
	ExtentSparkReporter reporter;
	ExtentReports report;
	ExtentTest test;
	
	public void setupReport() {
		reporter = new ExtentSparkReporter("LoginTestReport.html");
		report = new ExtentReports();
		report.attachReporter(reporter);		
	}
	
	public void setEnvirementSetup() {
		report.setSystemInfo("Author", "Gurdeep");
		report.setSystemInfo("OS", "Window");
		report.setSystemInfo("Browser", prop.getProperty("browser"));
		
		reporter.config().setDocumentTitle("Short Login Project");
		reporter.config().setReportName("Automation Login");
		reporter.config().setTheme(Theme.STANDARD);
		
	}
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
		test = report.createTest(result.getName());
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
