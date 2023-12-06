package module2;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TakeSS {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://nxtgenaiacademy.com/alertandpopup");
		driver.manage().window().maximize();
		
		//Full Page ScreenShot
//		TakesScreenshot ss = (TakesScreenshot) driver;
//		File dest1 = new File("C:\\Users\\gsdra\\eclipse-workspace\\siteAutomation\\ScreenShot\\FullPageSS.png");
//		File temp = ss.getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(temp, dest1);
		
		// Particular WebElement ScreenShot
		File dest2 = new File("C:\\Users\\gsdra\\eclipse-workspace\\siteAutomation\\ScreenShot\\AlertBoxSS.png");
		WebElement e1 = driver.findElement(By.name("alertbox"));
		File temp1 = e1.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(temp1, dest2);
		
		// Particular Section
		File dest3 = new File("C:\\Users\\gsdra\\eclipse-workspace\\siteAutomation\\ScreenShot\\ParticularSectionSS.png");
		e1 = driver.findElement(By.xpath("//div[@id='main']"));
		temp1 = e1.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(temp1, dest3);
		
	}

}
