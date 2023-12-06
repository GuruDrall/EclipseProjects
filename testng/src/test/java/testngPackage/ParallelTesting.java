package testngPackage;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ParallelTesting {
	public static WebDriver driver;
	public static WebDriver driver1;
	@Test (timeOut = 15000)
	void openCrome() throws IOException {
		driver = new ChromeDriver();
		HandleCalender.handleCalender(driver);
		System.out.println("Chrome");
	}

	@Test (timeOut = 15000)
	void openFirefox() throws IOException {
		driver1 = new FirefoxDriver();
		HandleCalender.handleCalender(driver1);
		System.out.println("Firefox");
	}
	
}
