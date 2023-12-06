package module1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AlertPopUpBox {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		Actions act = new Actions(driver);
		
// =================== 8. How to handle alert popup? ===========================
		
//		===================== Example 1 ========================
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		WebElement e3 = driver.findElement(By.xpath("//span[text()='right click me']"));
		act.contextClick(e3).perform();
		WebElement e4 = driver.findElement(By.xpath("//span[text()='Edit']"));
		act.moveToElement(e4).click(e4).perform();
		// Popup Handle
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		
//		===================== Example 2 ========================

		driver.get("https://nxtgenaiacademy.com/alertandpopup/");
		
		// ~~~~~~~~~ Only Alert ~~~~~~~~~~~~
		driver.findElement(By.xpath("//button[text()='Alert Box']")).click();
		Thread.sleep(1000);
		Alert a1 = driver.switchTo().alert();
		System.out.println(a1.getText());
		a1.accept();
		
		// ~~~~~~~~~~~ Alert with OK & Cancel ~~~~~~~~~~
		
		// Selecting "OK" from Alert Option
		driver.findElement(By.xpath("//button[text()='Confirm Alert Box']")).click();
		Thread.sleep(1000);
		Alert a2 = driver.switchTo().alert();
		System.out.println("=======================================================");
		System.out.println(a2.getText());
		a2.accept();
		WebElement e5 = driver.findElement(By.id("demo"));
		// Printing the Displayed msg
		System.out.println(e5.getText());
		
		// Selecting "CANCEL" from Alert Option
		driver.findElement(By.xpath("//button[text()='Confirm Alert Box']")).click();
		Thread.sleep(1000);
		Alert a3 = driver.switchTo().alert();
		System.out.println("=======================================================");
		System.out.println(a3.getText());
		a3.dismiss();
		WebElement e6 = driver.findElement(By.id("demo"));
		// Printing the Displayed msg
		System.out.println(e6.getText());
		
		// ~~~~~~~~~~~ Prompt Alert Option ~~~~~~~~~~
		// Providing "Yes" as input and clicking "OK"
		driver.findElement(By.xpath("//button[text()='Prompt Alert Box']")).click();
		Thread.sleep(1000);
		Alert a4 = driver.switchTo().alert();
		System.out.println("=======================================================");
		System.out.println(a4.getText());
		a4.sendKeys("Yes");
		System.out.println("Entered Yes");
		a4.accept();
		WebElement e7 = driver.findElement(By.id("demoone"));
		// Printing the Displayed msg
		System.out.println(e7.getText());
		
		// Providing "No" as input and clicking "OK"
		driver.findElement(By.xpath("//button[text()='Prompt Alert Box']")).click();
		Thread.sleep(1000);
		a4 = driver.switchTo().alert();
		System.out.println("=======================================================");
		System.out.println(a4.getText());
		a4.sendKeys("No");
		System.out.println("Entered No");
		a4.accept();
		WebElement e8 = driver.findElement(By.id("demoone"));
		// Printing the Displayed msg
		System.out.println(e8.getText());
		
		// Clicking on "CANCEL"
		driver.findElement(By.xpath("//button[text()='Prompt Alert Box']")).click();
		Thread.sleep(1000);
		a4 = driver.switchTo().alert();
		System.out.println("=======================================================");
		System.out.println(a4.getText());
		a4.dismiss();
		WebElement e9 = driver.findElement(By.id("demoone"));
		// Printing the Displayed msg
		System.out.println(e9.getText());

	}

}
