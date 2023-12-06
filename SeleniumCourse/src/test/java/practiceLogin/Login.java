package practiceLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class Login {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://practicetestautomation.com/practice-test-login/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.manage().window().maximize();

//		driver.findElement(By.id("username")).sendKeys("student");
//		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("student"); //xpath
//		driver.findElement(By.cssSelector("input#username")).sendKeys("student"); //cssSelector1 by tag and id
		driver.findElement(By.cssSelector("input[name=username]")).sendKeys("student"); //cssSelector2 by tag and attributes
		
		driver.findElement(By.id("password")).sendKeys("Password123");

//		driver.findElement(By.className("btn")).click();
//		driver.findElement(By.cssSelector("button.btn")).click(); //cssSelector3 by tag and classname
		driver.findElement(By.cssSelector("button.btn[id=submit]")).click(); //cssSelector4 by tag, classname, and attribute. 
		
		driver.findElement(By.linkText("Log out")).click();		
//		driver.close();
		

	}

}
