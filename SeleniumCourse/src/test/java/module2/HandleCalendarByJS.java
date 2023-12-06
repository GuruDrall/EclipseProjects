package module2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleCalendarByJS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.location='https://jqueryui.com/datepicker/'");
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));

//		WebElement e1 = driver.findElement(By.id("datepicker"));
//		e1.click();
//		e1.sendKeys("06/23/2024");
		
//		by  Javascript Executor
		js.executeScript("document.getElementById('datepicker').value='06/24/2024'");

	}

}
