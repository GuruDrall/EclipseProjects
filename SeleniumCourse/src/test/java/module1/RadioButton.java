package module1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButton {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		System.setProperty("webdriver.chrome.driver","C:\\Users\\gsdra\\eclipse-workspace\\siteAutomation\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://test.rubywatir.com/radios.php");
		driver.manage().window().maximize();

// ----------------------1. CLICK ON RADIO BUTTON---------------------
		// Selecting radio button with class
		WebElement e1 = driver.findElement(By.className("radioclass"));
		e1.click();

		// Selecting radio button using type attribute and index
		driver.findElement(By.xpath("//input[@type='radio'][4]")).click();

// ----------------------2. COUNTING RADIO BUTTON----------------------
		// Storing list of all radio type button
		List<WebElement> listOfRadioButton = driver.findElements(By.xpath("//input[@type='radio']"));

		// Printing the size of the list
		System.out.println("Number of Radio Button on Web Page are : " + listOfRadioButton.size());

// -----------------------3. CHECK RADIO BUTTON SELECTED OR NOT-----------------

		WebElement e2 = driver.findElement(By.xpath("//input[@class='radioclass']"));

		e1.click();
		if (e2.isSelected()) {
			System.out.println("Radio Button Selected");
		} else {
			System.out.println("Radio Button not selected");
		}



	}

}
