package module3;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AllWaits {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\gsdra\\eclipse-workspace\\siteAutomation\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// Page load timeout applied - but this wait is deprecated
		driver.manage().timeouts().pageLoadTimeout(4,TimeUnit.SECONDS);
		driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");
		driver.manage().window().maximize();
		
		// Alert box handle
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		
		// implicitlyWait
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		// we have to mention thread.sleep when using implicitlywait
//		Thread.sleep(6000);
		
		// for explicitlywait we have a special method for alertbox
		eWait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		
		// Fluent wait
		Wait<WebDriver> fwait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(Exception.class);
		
		// for getting text after wait
		driver.findElement(By.xpath("//button[@id='populate-text']")).click();
		// if using implicitly wait then have to provide 10 sec delay
//		Thread.sleep(11000);
		
		// Explicitly wait added
//		eWait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("//h2[@id='h2']")),"Selenium Webdrive"));
		
		//Fluent wait added
		fwait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("//h2[@id='h2']")),"Selenium Webdrive"));
		System.out.println(driver.findElement(By.xpath("//h2[@id='h2']")).getText());

		// Button which needs to be enable before click
		driver.findElement(By.xpath("//button[@id='display-other-button']")).click();
//		driver.findElement(By.xpath("//button[@id='hidden'][text()='Enabled']")).click();
		eWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='hidden'][text()='Enabled']"))).click();
		System.out.println("Clicked");
		
		// for clickable method
		driver.findElement(By.xpath("//button[@id='enable-button']")).click();
		eWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='disable']"))).click();
		System.out.println("Clickable button Clicked");
		
		//for checkbox
		driver.findElement(By.xpath("//button[@id='checkbox']")).click();
//		Thread.sleep(11000);
		WebElement e1 = driver.findElement(By.xpath("//input[@type='checkbox']"));
		eWait.until(ExpectedConditions.elementSelectionStateToBe(e1, true));

		if (e1.isSelected()) {
			System.out.println("Checkbox is Selected");
		} else {
			System.out.println("Checkbox is Not Selected");
		}
		
		driver.close();

	}

}
