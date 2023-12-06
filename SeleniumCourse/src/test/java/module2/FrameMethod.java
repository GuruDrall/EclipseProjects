package module2;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameMethod {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://www.rediff.com/");

		driver.switchTo().frame("moneyiframe");

		System.out.println(driver.findElement(By.id("nseindex")).getText());

		driver.switchTo().defaultContent();

		List<WebElement> e1 = driver.findElements(By.tagName("iframe"));

		System.out.println(e1.size());

//		WebElement e2 = driver.findElement(By.xpath("id=\"google_ads_iframe_/21677187305/Rediff_Home_728x90_ATF_IN_0\""));

//		driver.switchTo().frame("google_ads_iframe_/21677187305/Rediff_Home_728x90_ATF_IN_0");
		
		Thread.sleep(3000);
		
		File temp = (driver.findElement(By.xpath("//div[@class='div_advt_middle']"))).getScreenshotAs(OutputType.FILE);
		
		File f1 = new File(".\\ScreenShot\\Ad.png");
		
		FileUtils.copyFile(temp, f1);
		
		

//		for(WebElement e2:e1) {
//			
//			System.out.println(e2);
//			
//			
//		}

	}

}