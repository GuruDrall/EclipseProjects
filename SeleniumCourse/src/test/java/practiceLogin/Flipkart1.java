package practiceLogin;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Flipkart1 {

	public static void closeWebPage(WebDriver driver) {
		driver.close();
		System.out.println("Web Page Closed");
	}

	public static void openWebPage(WebDriver driver) {
		driver.get("https://www.flipkart.com/");
		System.out.println("Opening link - 'https://www.flipkart.com'");
		driver.manage().window().maximize();
		System.out.println("Window Maximized");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		try {
			driver.findElement(By.xpath("//button[text()='✕']")).click();
			System.out.println("Login Window Closed");
		} catch (Exception e) {
			System.out.println("Error while closing Login window - closing WebPage");
			closeWebPage(driver);
		}
	}

	public static String selectWindow(WebDriver driver,String id) {
		Set<String> handle1 = driver.getWindowHandles();
		Iterator it = handle1.iterator();
		String parentId = (String) it.next();
		String childId = (String) it.next();
		if (id.equals("child")) {
			System.out.println("Child Window Selected");
			return childId;
		} else {
			System.out.println("Parent Window Selected");
			return parentId;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\gsdra\\eclipse-workspace\\siteAutomation\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		System.out.println("Chrome Opened");

		Flipkart1.openWebPage(driver);

		driver.findElement(By.className("_3704LK")).sendKeys("iphone 14 pro", Keys.ENTER);

		// 3 sec wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		// clicking on selected iPhone to order
		driver.findElement(By.xpath("//img[@loading='eager'][@alt='APPLE iPhone 14 Pro (Silver, 128 GB)']")).click();
		System.out.println("iPhone selected to add into cart");
		String whichWindow = "child";
		String childWindow = selectWindow(driver,whichWindow);
		driver.switchTo().window(childWindow);

		// selecting 512 GB varient
		driver.findElement(By.xpath("//a[text()='1 TB']")).click();

		// click on add to cart button
//		driver.findElement(By.xpath("//button[text()='Add to cart']")).click();
		try {
			driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")).click();
		} catch (Exception e) {
			System.out.println("Not added in cart");
		}
		System.out.println("Added into cart");

		// clicking on Place Order
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2ObVJD _3AWRsL']")).click();
		System.out.println("Program Run Successfully");
		
		whichWindow = "parent";
		String parentWindow = selectWindow(driver,whichWindow);
		driver.switchTo().window(parentWindow);
		
		closeWebPage(driver);
		
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
//		
//		
//	
//		closeWebPage(driver);
	}

}
