package TestCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
	public static WebDriver driver;
	public static Properties prop;
	public static FileInputStream fis;
	
	String browser;
	
	
	@BeforeSuite
	public void loadProperties() {
		prop = new Properties();
		
		String fileName = "C:\\Users\\gsdra\\eclipse-workspace\\SauceDemo\\Configuration Files\\Config.properties";
		try {
		 fis = new FileInputStream(fileName);
		} catch (FileNotFoundException e) {
			System.out.println("Properties file not found :" + e);
		}
		try {
			prop.load(fis);
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		browser = prop.getProperty("browser"); // browser = "chrome";
		System.out.println(browser);
	}
	
	
	public void launchBrowser() {
		switch (browser.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "ie":
			driver = new InternetExplorerDriver();
			break;
		default:
			System.out.println("browser is null");
		
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	public void openURL(){
		driver.get(prop.getProperty("url"));
	}
	
	public void screenshot() {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		File destination = new File("C:\\Users\\gsdra\\eclipse-workspace\\SauceDemo\\Screenshots\\ss1");
		try {
			FileUtils.copyFile(source, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void waitForElementToAppear(By loc) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(loc));
	}
	@AfterSuite
	public void tearDown() {
		driver.quit();
	}
}
