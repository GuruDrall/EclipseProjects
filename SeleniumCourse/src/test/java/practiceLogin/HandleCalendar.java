package practiceLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleCalendar {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\gsdra\\eclipse-workspace\\siteAutomation\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/datepicker");
		driver.manage().window().maximize();

		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		driver.findElement(By.id("datepicker")).click();

		String eMonth = "December";
		String eYear = "2023";
		String eDate = "3";
		
		WebElement dMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']"));
		WebElement dYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']"));
		
		while ( !(eMonth.equals(dMonth.getText()) && eYear.equals(dYear.getText())) ) {
			
			WebElement nextButton = driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']"));
			nextButton.click();
			
			dMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']"));
			dYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']"));
			
		}
		
		String dateXPath = "//td/a[@class='ui-state-default'][text()='" + eDate+"']";
//		System.out.println(dateXPath);
		
		WebElement dDate = driver.findElement(By.xpath(dateXPath));
//		WebElement dDate = driver.findElement("//td/a[@class='ui-state-default'][text()='" + eDate+"']")); // same as above
		dDate.click();
		
	}

}
