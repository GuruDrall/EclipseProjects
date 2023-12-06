package com.main.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.shortProj.utility.ExcelLibrary;

public class BaseClass1 {
	public static WebDriver driver;
	public static Properties prop;

	@BeforeSuite
	void loadConfig() {
		try {
			prop = new Properties();
			String propPath = "C:\\Users\\gsdra\\eclipse-workspace\\ShortLoginProject\\src\\test\\resources\\config.properties";
			File file1 = new File(propPath);
			FileInputStream fInput = new FileInputStream(file1);
			prop.load(fInput);
			System.out.println("Using driver : " + prop.getProperty("browser"));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		

	}
	
	public void launchBrowser() {
		String browserName = prop.getProperty("browser");
		if (browserName.contains("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.contains("firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.contains("ie")) {
			driver = new InternetExplorerDriver();
		} else if (browserName.contains("edge")) {
			driver = new EdgeDriver();
		} else {
			System.out.println("Browser Not Supported");
		}
	}
	
	public void openURL() {
		driver.get(prop.getProperty("url"));
	}
	

	@AfterSuite
	void AS() {
		driver.close();

	}

}
