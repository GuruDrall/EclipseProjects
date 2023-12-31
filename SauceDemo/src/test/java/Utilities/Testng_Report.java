package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import TestCases.BaseClass;

public class Testng_Report extends BaseClass {
	ExtentSparkReporter reporter;
	ExtentReports report;
	ExtentTest test;
	
	public void setupReport() {
		reporter = new ExtentSparkReporter("SauceDemoReport.html");
		report = new ExtentReports();
		report.attachReporter(reporter);		
	}
	
	public void setEnvirementSetup() {
		report.setSystemInfo("Author", "Gurdeep");
		report.setSystemInfo("OS", "Window");
		report.setSystemInfo("Browser", prop.getProperty("browser"));
		
		reporter.config().setDocumentTitle("Sauce Demo Project");
		reporter.config().setReportName("Automation Login");
		reporter.config().setTheme(Theme.STANDARD);
		
	}

}
