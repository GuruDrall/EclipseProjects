package module4;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\gsdra\\eclipse-workspace\\siteAutomation\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// ReadFileClass object created (create created by us)
		ReadFileClass rf = new ReadFileClass();
		// when object created, constructor load the file to readfileclass object
		// has all methods which we have declared in readfileclass
		driver.get(rf.getUrl());
		
		driver.findElement(By.id("username")).sendKeys(rf.getUsername());
		driver.findElement(By.id("password")).sendKeys(rf.getPassword());
		driver.findElement(By.id("submit")).click();

	}

}
