package module1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hyperlink {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.calculator.net/");
		
// =================== 1. COUNT TOTAL HYPERLINKS IN WEBPAGE ================
		List<WebElement> list = driver.findElements(By.tagName("a"));
		System.out.println(list.size());
		
// =================== 2. DISPLAY ALL HYPERLINKS PRESENT IN WEBPAGE ============
		for (WebElement temp : list) {
			System.out.println(temp.getText());
		}

	}

}
