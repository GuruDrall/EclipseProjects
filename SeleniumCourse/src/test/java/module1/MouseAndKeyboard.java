package module1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class MouseAndKeyboard {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method 
//		System.setProperty("webdriver.chrome.driver","C:\\Users\\gsdra\\eclipse-workspace\\siteAutomation\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
//		driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		driver.manage().window().maximize();
		
		
// ============= 1. How to handle mouse and keyboard operation? - USING ACTION and PERFORM CLASS =====================
		Actions act = new Actions(driver);
		System.out.println("Action 1 - Done");
		
// ================== 2. How to perform right click? =============================
		
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		WebElement e0 = driver.findElement(By.xpath("//span[text()='right click me']"));
		// Performing right click using contextClick method
		act.contextClick(e0).perform();
		System.out.println("Action 2 - Done");
		
// ================== 3. How to perform double click? ========================
		driver.get("https://nxtgenaiacademy.com/alertandpopup/");
		WebElement demoSite = driver.findElement(By.linkText("Demo Sites"));
		act.moveToElement(demoSite).perform();
		
		act.moveToElement(driver.findElement(By.linkText("Practice Automation"))).perform(); // Xpath for 2nd move mouse
		driver.findElement(By.linkText("Demo Site – Mouse Event")).click();
		// Performing Double Click
		act.doubleClick(driver.findElement(By.id("dblclick"))).perform();
		String doubleClickMsg = driver.findElement(By.xpath("//p[@id='demo']")).getText();
		System.out.println(doubleClickMsg);
		Thread.sleep(3000);
		System.out.println("Action 3 - Done");
		
// ================== 4. How to perform dragAndDrop? =======================
		driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		WebElement source = driver.findElement(By.id("box7"));
		WebElement destination = driver.findElement(By.id("box107"));
		act.dragAndDrop(source, destination).build().perform();
		System.out.println("Action 4 - Done");
				
		
// ==================== 5. How to perform mouse over? =========================
		driver.get("https://www.ebay.in/");
		WebElement e1 = driver.findElement(By.linkText("Listing"));
		act.moveToElement(e1).perform();
		WebElement e2 = driver.findElement(By.linkText("Photo Tips"));
		act.moveToElement(e2).click().perform();
		System.out.println("Action 5 - Done");
		
// ==================== 6. How to press enter keys? ============================
		
		driver.get("http://google.in");
		driver.findElement(By.xpath("//textarea[@class='gLFyf']")).sendKeys("Today's Date");
		act.sendKeys(Keys.ENTER).perform();
		System.out.println("Action 6 - Done");
		
// =================== 7. How to press control keys? ===========================
		
		driver.findElement(By.xpath("//textarea[@class='gLFyf']")).sendKeys("");
		act
		.keyDown(Keys.CONTROL)
		.sendKeys("a")
		.keyUp(Keys.CONTROL).perform();
		System.out.println("Action 7 - Done");

	}

}
