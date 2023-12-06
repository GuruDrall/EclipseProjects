package module2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewTabWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.opencart.com");
		// To open new Tab
		driver.switchTo().newWindow(WindowType.TAB);
		// To open new window
		driver.switchTo().newWindow(WindowType.WINDOW);

	}

}
