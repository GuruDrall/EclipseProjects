package testngPackage;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Report1 {
	
	ExtentSparkReporter createReport;
	ExtentReports createTest;
	ExtentTest createLog;

	@BeforeTest
	void setup() {
		System.out.println("Running");
		createReport = new ExtentSparkReporter("TestNG Report.html");
		createTest = new ExtentReports();
		createTest.attachReporter(createReport);
		createTest.setSystemInfo("Operating System", "Window");
		createTest.setSystemInfo("Browser", "Chrome");
		createTest.setSystemInfo("BrowserVersion", "118.0.5993.118");
		createTest.setSystemInfo("Environment", "Testing");
		createTest.setSystemInfo("User Name", "Gurdeep Singh Drall");
		createReport.config().setDocumentTitle("MyFirstReportInfo");
		createReport.config().setReportName("Extent-Reports");
		createReport.config().setTheme(Theme.DARK);
		System.out.println("Run Successfully - ER");
	}
	@AfterTest
	void end() {
		createTest.flush();
	}
}
