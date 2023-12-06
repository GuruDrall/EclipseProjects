package module3;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSWebElementRelated {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		driver.manage().window().maximize();
		driver.get("https://practicetestautomation.com/practice-test-login/");
		
//=================	WebElement Related Script ==========================
		// To refresh the browser
		Thread.sleep(2000);
		js.executeScript("history.go(0)");
		System.out.println("Run Sucessfully");
		
		// To type text in text box
//		js.executeScript("document.getElementById('username').value='student';");
//		js.executeScript("document.getElementById('password').value='Password123';");
		
		// To click an a button
//		WebElement e1=driver.findElement(By.id("submit"));
//		js.executeScript("arguments[0].click();", e1);
		
		// To Draw boarder around element
//		WebElement e2=driver.findElement(By.linkText("Log out"));
//		js.executeScript("arguments[0].style.border='3px solid red';",e2);
		
		// The scrollIntoView() method scrolls an element into the visible area of thebrowser window.
		// javaScriptExecutor_Var.executeScript("arguments[0].scrollIntoView();",Element);
//		js.executeScript("arguments[0].scrollIntoView();",e1);
	}

}
