package testngPackage;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersDemo extends Report1 implements ITestListener {
	// Creating object of ExtentSparkReporter
		ExtentSparkReporter createReport = new ExtentSparkReporter("TestNG Report With Listeners.html");
		// Creating object of ExtentReports
		ExtentReports createTest = new ExtentReports();
		// Creating Variable of ExtentTest Class
		ExtentTest createLog;
		
		void setupReport() {
			System.out.println("Class Demo Started");
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

	@Override
	public void onStart(ITestContext context) {
		
		setupReport();
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(result.getName() + " Method Started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		createLog = createTest.createTest(result.getName());
		createLog.log(Status.PASS, MarkupHelper.createLabel("TestCase Pass", ExtentColor.GREEN));

		if (result.getStatus() == 1) {
			System.out.println("====== SUCCESS ======");
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		createLog = createTest.createTest(result.getName());
		createLog.log(Status.FAIL, MarkupHelper.createLabel("TestCase Fail", ExtentColor.RED));

		if (result.getStatus() == 2) {
			System.out.println("====== Failure ======");
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		createLog = createTest.createTest(result.getName());
		createLog.log(Status.WARNING, MarkupHelper.createLabel("TestCase Skipped", ExtentColor.RED));

		System.out.println("TestCase Skipped : " + result.getName() + " " + result.getStatus());
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		createLog = createTest.createTest(result.getName());
		createLog.log(Status.WARNING, MarkupHelper.createLabel("TestCase Fail Due to Timeout", ExtentColor.RED));

		System.out.println("====== TestCase Failed due to Timeout : " + result.getName() + " " + result.getStatus() + " ======");
	}

	@Override
	public void onFinish(ITestContext context) {
		if (context.getFailedTests().size() == 0) {
			System.out.println("=============== All Test Cases Executed Successfully ===============");
		} else {
			System.out.println("====== Total Test Case Failed : " + context.getFailedTests().size() + " ======");
		}
		createTest.flush();
	}

}
