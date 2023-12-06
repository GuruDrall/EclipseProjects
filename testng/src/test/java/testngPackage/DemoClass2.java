package testngPackage;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class DemoClass2 {
	// Creating object of ExtentSparkReporter
	ExtentSparkReporter createReport;
	// Creating object of ExtentReports
	ExtentReports createTest;
	// Creating Variable of ExtentTest Class
	ExtentTest createLog;

	@BeforeTest
	void setup() {
		createReport = new ExtentSparkReporter("TestNG Report2.html");
		createTest = new ExtentReports();
		createTest.attachReporter(createReport);
		// System Settings
		createTest.setSystemInfo("Operating System", "Window");
		createTest.setSystemInfo("Browser", "Chrome");
		createTest.setSystemInfo("BrowserVersion", "118.0.5993.118");
		createTest.setSystemInfo("Environment", "Testing");
		createTest.setSystemInfo("User Name", "Gurdeep Singh Drall");
		// Report Title, Report Name and Theme
		createReport.config().setDocumentTitle("MyFirstReportInfo");
		createReport.config().setReportName("TestNG-Reports");
		createReport.config().setTheme(Theme.STANDARD);
	}

	@Test
	public void m1() {
		System.out.println("Done");
	}

	@Test
	public void m2() {
		Assert.assertFalse(true);
		System.out.println("Done");
	}

	@Test
	public void m3() {
		System.out.println("Done");
	}

	@Test
	public void m4() {
		
		System.out.println("Skip");
		throw new SkipException("Method Skipped"); 
	}

	@AfterMethod
	void testcaseresult(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			createLog = createTest.createTest(result.getName());
			createLog.log(Status.PASS, MarkupHelper.createLabel("TestCase Pass", ExtentColor.GREEN));
		} 
		else if (result.getStatus() == ITestResult.FAILURE) {
			createLog = createTest.createTest(result.getName());
			createLog.log(Status.FAIL, MarkupHelper.createLabel("TestCase Fail", ExtentColor.RED));
		} else if (result.getStatus() == ITestResult.SKIP) {
			createLog = createTest.createTest(result.getName());
			createLog.log(Status.WARNING, MarkupHelper.createLabel("TestCase Fail Due to Timeout", ExtentColor.RED));
		} 
		else {
			System.out.println(result.getStatus());
		}

	}
	@AfterTest
	void tearDown() {
		// Appends the HTML file with all the ended tests
		createTest.flush();
	}
}
