package testngPackage;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HandleCalender extends ParallelTesting{

	public static void handleCalender(WebDriver driver) throws IOException {
		

		driver.get("https://jqueryui.com/datepicker/");
//		driver.manage().window().maximize();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		driver.findElement(By.id("datepicker")).click();

		String expDay = "23";
		String expMonth = "June";
		String expYear = "2024";

		boolean condition = true;

		while (condition == true) {
			String actMonth = driver.findElement(By.className("ui-datepicker-month")).getText();
			String actYear = driver.findElement(By.className("ui-datepicker-year")).getText();

			if (actMonth.equals(expMonth) && (actYear.equals(expYear))) {
				List<WebElement> dayList = driver.findElements(By.xpath("//table/tbody/tr/td"));
				for (WebElement days : dayList) {
					String actDay = days.getText();
					if (actDay.equals(expDay)) {
						days.click();
						condition = false;
						break;
					}
				}
			} else {
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			}
		}
	}
}
