package testngPackage;

import org.testng.Assert;
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

public class DemoClass {
	// Creating object of ExtentSparkReporter
	ExtentSparkReporter createReport = new ExtentSparkReporter("TestNG Report.html");
	// Creating object of ExtentReports
	ExtentReports createTest = new ExtentReports();
	// Creating Variable of ExtentTest Class
	ExtentTest createLog;

	@BeforeTest
	void setup() {
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
		createReport.config().setTheme(Theme.DARK);
	}

	@AfterTest
	void end() {
		// Appends the HTML file with all the ended tests
		createTest.flush();
	}

	@Test
	public void m1() {
		createLog = createTest.createTest("m1");
		createLog.log(Status.PASS, MarkupHelper.createLabel("TestCase Pass", ExtentColor.GREEN));
		System.out.println("Done");
	}

	@Test
	public void m2() {
		createLog = createTest.createTest("m2");
		createLog.log(Status.FAIL, MarkupHelper.createLabel("TestCase Fail", ExtentColor.RED));
		Assert.assertFalse(true);
		System.out.println("Done");
	}

	@Test(timeOut = 500)
	public void m3() throws InterruptedException {
		createLog = createTest.createTest("m3");
		createLog.log(Status.WARNING, MarkupHelper.createLabel("TestCase Fail Due to Timeout", ExtentColor.RED));
		Thread.sleep(1000);
		System.out.println("Done");
	}

	@Test(dependsOnMethods = { "m2" })
	public void m4() {
		createLog = createTest.createTest("m4");
		createLog.log(Status.SKIP, MarkupHelper.createLabel("TestCase Skipped", ExtentColor.ORANGE));
		System.out.println("Done");
	}

}
