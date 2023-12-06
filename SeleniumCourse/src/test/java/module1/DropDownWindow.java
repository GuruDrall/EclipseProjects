package module1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.globalsqa.com/demo-site/select-dropdown-menu/");
		driver.manage().window().maximize();

// ================ 1. How to handle drop-down list? --- BY SELECT CLASS ====================
		// Save the WebElement - Using tagName locator
		WebElement e1 = driver.findElement(By.tagName("select"));
		// Create a object of select class
		Select s = new Select(e1);

// ================ 2. How to select with text? ====================
		// selecting using text method
		s.selectByVisibleText("India");
		System.out.println("Value is selected by using VisibleText method");

// =============== 3. How to select with value? =====================
		// selecting using value method
		s.selectByValue("BHS");
		System.out.println("Value is selected by using Value method");

// ================= 4. How to select with index? ====================
		// selecting using index method
		s.selectByIndex(26);
		System.out.println("Value is selected by using Index method");

// ================== 5. How to count total dropdown? ========================

		// Saving option WebElemnet into a list of WebElement
		List<WebElement> listOfOption = s.getOptions();

		// Displaying list
		for (WebElement temp : listOfOption) {
			System.out.println(temp.getText());
		}
		// Counting Dropdown window using getOption
		int size = listOfOption.size();
		System.out.println("Total count is : " + size);

//How to get all values of dropdown without select class in Selenium ?
//How will you check whether you are able to input multiple values in dropdown?
//How to get all values of dropdown in Selenium ?
//What are different methods in select class?How to check radio button selected or not?
		
		driver.close();

	}

}
