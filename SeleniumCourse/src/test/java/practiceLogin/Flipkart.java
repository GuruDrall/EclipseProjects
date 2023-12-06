package practiceLogin;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Flipkart {

	public static void main(String[] args) { // ctrl + space + enter

		WebDriver driver = new ChromeDriver(); // short-cut keys {ctrl + shift + "O"}
		// open Flipkart app
		driver.get("https://www.flipkart.com/");

		// maximize the window
		driver.manage().window().maximize();

		// 3 sec wait
//		try {
//			Thread.sleep(3000);
//		} catch (Exception e) {
//
//			System.out.println("Sleeping");
//		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		// closing login window by button
		try {
			driver.findElement(By.xpath("//button[text()='✕']")).click();
		} catch (Exception e) {
			System.out.println("button error, now using span");
			driver.findElement(By.xpath("//span[text()='✕']")).click();
		}


		// enter search content
//		driver.findElement(By.className("_3704LK")).sendKeys("iphone 14 pro");
		driver.findElement(By.className("_3704LK")).sendKeys("iphone 14 pro" , Keys.ENTER);
		// click to search
//		driver.findElement(By.xpath("//button[@class='L0Z3Pu']")).click();

		// 3 sec wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	

		// clicking on selected iPhone to order
		driver.findElement(By.xpath("//img[@loading='eager'][@alt='APPLE iPhone 14 Pro (Silver, 128 GB)']")).click();
		System.out.println("iPhone selected to add into cart");
		
		Set<String> handle1 = driver.getWindowHandles();
		
		Iterator it = handle1.iterator();
		
		String parentId = (String)it.next();
		String childId = (String)it.next();
		
		driver.switchTo().window(childId);
		
		
		// selecting 512 GB varient
		driver.findElement(By.xpath("//a[text()='512 GB']")).click();


		
		// click on add to cart button
//		driver.findElement(By.xpath("//button[text()='Add to cart']")).click();
		try {
			driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")).click();
		} catch (Exception e) {
			System.out.println("Not added in cart");

		}
		System.out.println("Added into cart");
		
		driver.quit();
	}

}
