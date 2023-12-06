package module1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropDownWindow2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.mobiscroll.com/select/country-picker");
		driver.manage().window().maximize();

		String cityName = "Angola";
		Thread.sleep(2000);
		WebElement e1 = driver.findElement(By.xpath("//input[@id='demo155-country-picker']"));
		e1.click();
//		WebElement e2 = driver.findElement(By.xpath("//div[@class='md-country-picker-item']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.querySelector('.mbsc-scroller-wheel-cont.mbsc-scroller-wheel-cont-anchored.mbsc-ios').scrollTop=5000");
		List<WebElement> listOfCountry = driver.findElements(By.xpath("//div[@class='md-country-picker-item']"));
		System.out.println("List added");
		for (WebElement temp : listOfCountry) {
//			if (cityName.equals(temp.getText())) {
//				temp.click();
//				return;
				System.out.println(temp.getText());
//			}
		}

	}

}
